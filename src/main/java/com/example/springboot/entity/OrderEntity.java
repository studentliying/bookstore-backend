package com.example.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="orders")
public class OrderEntity {
    private int id;
    private String submittime;
    private String username;
    private String bookname;
    private int amount;
    private double price;
    private double sum;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "submittime")
    public String getSubmittime() {
        return submittime;
    }

    public void setSubmittime(String submittime) {
        this.submittime = submittime;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "bookname")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "sum")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id &&
                Objects.equals(submittime, that.submittime) &&
                Objects.equals(username, that.username) &&
                Objects.equals(bookname, that.bookname) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(price, that.price) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, submittime, username, bookname, amount, price, sum);
    }
}
