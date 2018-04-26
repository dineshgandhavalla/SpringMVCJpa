package com.example.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bookapp.exceptions.AuthorNotFoundException;
import com.example.bookapp.exceptions.BookNotFoundException;
import com.example.bookapp.model.Book;
import com.example.bookapp.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping(value = "/")
	public String homePage(Model model) {
		List<Book> bookList = bookService.getAllBooks();
		model.addAttribute("bookList", bookList);
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String bookSearch(@RequestParam("choice") String author, Model model) throws AuthorNotFoundException {
		List<Book> bookList = bookService.getBookByAuthor(author);
		model.addAttribute("bookList", bookList);
		return "home";

	}

	@GetMapping(value = "/loginForm")
	public String showLoginForm(Model model) {
		return "login";
	}

	@GetMapping(value = "/login")
	public String login(@RequestParam("userid") int userid, String password) {
		if((userid==1234)&& password.equals("abcd")) {
			return "admin";
		}else {
		return "login";
		}
		}

	@GetMapping(value = "/showAddForm")
	public String showAddForm(Model model) {
		return "addBook";
	}

	@PostMapping(value = "/addBook")
	public String addBook(Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("result", "Enter proper values");
			return "addBook";
		}
		bookService.addBook(book);
		model.addAttribute("result", "added successfully");
		return "admin";
	}

	@GetMapping(value = "/showDeleteForm")
	public String showDeleteForm() {
		return "deleteBook";
	}

	@GetMapping(value = "/deleteBook")
	public String deleteBook(@RequestParam("bookid") String id,Model model) throws BookNotFoundException {
		int bookid = Integer.parseInt(id);
		if(bookid<=0) {
			model.addAttribute("deleteResult", "enter a valid id");
			return "deleteBook";
		}
		bookService.deleteBook(bookid);
		model.addAttribute("delete", "deleted successfully");
		return "admin";
	}

	@GetMapping(value = "/editBook")
	public String updateBookForm(@RequestParam("bookid") String id, Model model)
			throws BookNotFoundException {
		int bookid= Integer.parseInt(id);
		Book book = null;
		if (bookid <= 0) {
			model.addAttribute("editResult", "Invalid Id");
			return "editBook";
		}

		book = bookService.getBookById(bookid);
		if (book == null) {
			model.addAttribute("editResult", "Invalid Id");
			return "editBook";
		}
		model.addAttribute("book", book);
		return "updateBook";

	}

	@GetMapping(value="/updateBook")
	public String updateBook(Book book,Model model) throws BookNotFoundException {
		bookService.updateBook(book);
		model.addAttribute("update", "book updated successfully");
		return "admin";
		
	}
	@GetMapping(value = "/showEditForm")
	public String showEditForm() {
		return "editBook";
	}


	@ExceptionHandler(value = AuthorNotFoundException.class)
	public String handleAuthorException(Model model) {
		model.addAttribute("msg", "No Books found");
		return "home";
	}

	
	@ExceptionHandler(value = BookNotFoundException.class)
	public String BookNotFoundException(Model model) {
		model.addAttribute("bookmsg", "Book not found");
		return "admin";
	}
}
