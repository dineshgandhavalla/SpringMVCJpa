package com.example.bookapp.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookapp.model.Book;



@Repository
public interface BookRepository  extends JpaRepository<Book, Integer>{
	
	public List<Book> findByAuthor(String author);
	List<Book> findByTitleAndCategory(String title, String category);

}
