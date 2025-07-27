package br.com.darp.domain;

import java.util.Objects;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="books")
public class Book {
    public ObjectId id; // MongoDB irá gerar automaticamente
    private String title;
    private String author;
    private boolean reading;
    private boolean read;
    private String finishedAt;

    public Book() {}

    // Remova o parâmetro id do construtor
    public Book(String title, String author, boolean reading, boolean read, String finishedAt) {
        this.title = title;
        this.author = author;
        this.reading = reading;
        this.read = read;
        this.finishedAt = finishedAt;
    }

    // Getters e Setters

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isReading() { return reading; }
    public void setReading(boolean reading) { this.reading = reading; }

    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }

    public String getFinishedAt() { return finishedAt; }
    public void setFinishedAt(String finishedAt) { this.finishedAt = finishedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
