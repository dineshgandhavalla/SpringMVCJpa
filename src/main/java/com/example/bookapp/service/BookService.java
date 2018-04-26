package com.example.bookapp.service;

import java.util.List;
import java.util.Optional;

import com.example.bookapp.exceptions.AuthorNotFoundException;
import com.example.bookapp.exceptions.BookNotFoundException;
import com.example.bookapp.exceptions.CategoryNotFoundException;
import com.example.bookapp.model.Book;




public interface BookService {
	//called by admin
		void addBook(Book book);
		void deleteBook(int bookid) throws BookNotFoundException;
		Book getBookById(int bookid) throws BookNotFoundException;
		boolean updateBook(Book book) throws BookNotFoundException;
		
		// called by coustomer
		List<Book> getAllBooks();
		List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;
 		List<Book> getBookByCategory(String category) throws CategoryNotFoundException;
		
}
