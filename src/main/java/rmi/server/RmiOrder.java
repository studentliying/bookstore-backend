package rmi.server;

import java.io.*;

public class RmiOrder implements Serializable
{
	private int id;
	private String username;
	private String submittime;
	private String bookname;
	private int amount;
	private double price;
	private double sum;

	public RmiOrder() {}

	public RmiOrder(String username, String submittime, String bookname, int amount, double price, double sum)
	{
		this.username = username;
		this.submittime = submittime;
		this.bookname = bookname;
		this.amount = amount;
		this.price = price;
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubmittime() {
		return submittime;
	}

	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
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

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
}

