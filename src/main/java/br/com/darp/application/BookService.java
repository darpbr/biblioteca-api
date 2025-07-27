package br.com.darp.application;

import java.util.List;
import java.util.Optional;

import br.com.darp.domain.Book;
import br.com.darp.domain.BookRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository repository;

    public Book create(Book book) {
        return repository.save(book);
    }

    public List<Book> listAll() {
        return repository.listAll();
    }

    public Book getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Optional<Book> getCurrentReading() {
        return repository.findCurrentReading();
    }

    public void setCurrentReading(String id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        List<Book> currentReadings = repository.listAll().stream()
                .filter(Book::isReading)
                .toList();
        if (!currentReadings.isEmpty()) {
            Log.warn("There is already a book being read. Setting it to not reading.");
            currentReadings.forEach(b -> {
                b.setReading(false);
                repository.setCurrentReading(b);
            });
        }
        book.setReading(true);
        repository.setCurrentReading(book);
    }

    public void markAsRead(String id, String finishedAt) {
        Log.info("Marking book with ID " + id + " as read, finished at: " + finishedAt);
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        book.setRead(true);
        book.setReading(false);
        book.setFinishedAt(finishedAt);
        repository.markAsRead(book);
    }
}
