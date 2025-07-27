package br.com.darp.infrastructure;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import br.com.darp.domain.Book;
import br.com.darp.domain.BookRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository, PanacheMongoRepository<Book> {

    @Override
    public Book save(Book book) {
        persistOrUpdate(book);
        return book;
    }

    @Override
    public List<Book> listAll() {
        return findAll().list();
    }

    @Override
    public Optional<Book> findById(String id) {
        return find("_id", new ObjectId(id)).firstResultOptional();
    }

    @Override
    public void deleteById(String id) {
        delete("_id", new ObjectId(id));
    }

    @Override
    public Optional<Book> findCurrentReading() {
        return find("reading", true).firstResultOptional();
    }

    @Override
    public void setCurrentReading(Book book) {
        update(book);
    }

    @Override
    public void markAsRead(Book book) {
        update(book);
    }
}
