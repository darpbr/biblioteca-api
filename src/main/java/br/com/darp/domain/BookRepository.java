package br.com.darp.domain;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> listAll();
    Optional<Book> findById(String id);
    void deleteById(String id);
    Optional<Book> findCurrentReading();
    void setCurrentReading(Book book);
    void markAsRead(Book book);
}
