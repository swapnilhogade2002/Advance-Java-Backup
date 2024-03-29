package com.test.controller;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Books;
import com.test.service.BookService;

//@Controller
//@ResponseBody (when use@RestController no need response body)

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

//	getting multiple books
//	ResponseEntity- It's useful for sending error code message
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Books>> getBooks() {
		List<Books> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
//		Books books = new Books();
//		books.setId(1);
//		books.setName("Shyamchi Aai");
//		books.setAuthor("Sane guruji");
//		return books;
	}

//	getting single books
	@GetMapping("books/{id}")
	public Books getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}

//	adding book
	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		this.bookService.addBook(book);
		return book;
	}

//	deleting book
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookService.deleteBook(bookId);
	}

//	update Books
	@RequestMapping("/books/{bookId}")
	public Books deleteBooks(@RequestBody Books book, @PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book, bookId);
		return book;

	}

}
