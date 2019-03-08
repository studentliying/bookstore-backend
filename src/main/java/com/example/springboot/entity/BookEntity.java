package com.example.springboot.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="book")
public class BookEntity {
    private String bookname;
    private String author;
    private String language;
    private int amount;
    private double price;
    private String kind;
    private String tag;
    private String src;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSrc() { return src; }

    public void setSrc(String src) { this.src = src; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return amount == that.amount &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(bookname, that.bookname) &&
                Objects.equals(author, that.author) &&
                Objects.equals(language, that.language) &&
                Objects.equals(kind, that.kind) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookname, author, language, amount, price, kind, tag, src);
    }
}
