package com.example.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="cart")
public class CartEntity {
    private String userbook;
    private String username;
    private String bookname;
    private String author;
    private int amount;
    private double price;

    public String getUserbook() {
        return userbook;
    }

    public void setUserbook(String userbook) {
        this.userbook = userbook;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return amount == that.amount &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(username, that.username) &&
                Objects.equals(bookname, that.bookname) &&
                Objects.equals(author, that.author) &&
                Objects.equals(userbook, that.userbook);

    }

    @Override
    public int hashCode() {

        return Objects.hash(userbook, username, bookname, author, amount, price);
    }
}
