package com.example.bookapp.service;

import java.util.List;



import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.bookapp.dao.BookRepository;
import com.example.bookapp.exceptions.AuthorNotFoundException;
import com.example.bookapp.exceptions.BookNotFoundException;
import com.example.bookapp.exceptions.CategoryNotFoundException;
import com.example.bookapp.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public void addBook(Book book) {

		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookid) throws BookNotFoundException{
		try {
			bookRepository.deleteById(bookid);
		} catch (Exception e) {
			throw new BookNotFoundException("Id not available");
		}
	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		Book book;
		try {
			book = bookRepository.findById(bookid).get();
		} catch (Exception e) {
			throw new BookNotFoundException("No Book Found");
		}
	
		return book;
	}

	@Override
	public boolean updateBook(Book book)  {
		bookRepository.save(book);
		return true;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> bookList = bookRepository.findByAuthor(author);
		if(bookList.isEmpty()) {
			throw new AuthorNotFoundException("author not found");
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		return bookRepository.findByTitleAndCategory("Java", category);
	}


}
