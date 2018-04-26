package com.example.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.annotations.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	private String title,author,category;
	private int price;
	@Id 
	
	@GeneratedValue(generator = "seq")
	@GenericGenerator(
	        name = "seq",
	        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	        parameters = {
	                @Parameter(name = "sequence_name", value = "mysequence"),
	                @Parameter(name = "initial_value", value = "1"),
	                @Parameter(name = "increment_size", value = "1")
	        }
	)
	private Integer bookid;
	
	
	public Book() {
		super();
		}
	
	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", bookid=" + bookid + "]";
	}

}
