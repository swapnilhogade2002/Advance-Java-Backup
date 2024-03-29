package com.test.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dao.BookRepository;
import com.test.entity.Books;

@Component
public class BookService {

	@Autowired
	BookRepository bookRepository;
//	we calling book repo so no need to here fake below data

//	private static List<Books> list = new ArrayList<>();
//
//	static {
//		list.add(new Books(1, "shyam", "ram"));
//		list.add(new Books(2, "xyz", "hjcw"));
//	}

//	get all books
	public List<Books> getAllBooks() {
//		return list;
		Iterable<Books> list = this.bookRepository.findAll();
		return (List<Books>) list;
	}

//	get book single
	public Books getBookById(int id) {
		Books book = null;
//		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		this.bookRepository.findById(id);
		return book;
	}

//	add book
	public Books addBook(Books b) {
//		list.add(b);
		Books save = bookRepository.save(b);
		return save;

	}

//	delete book

	public void deleteBook(int bid) {
//		method-1
//		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

//		method-2
//		list.stream().filter(book -> {
//			if (book.getId() != bid) {
//				return true;
//			} else {
//				return false;
//			}
//		}).collect(Collectors.toList());

		
		bookRepository.deleteById(bid);
	}

	public void updateBook(Books book, int bookId) {
//		list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setAuthor(book.getAuthor());
//				b.setName(book.getName());
//			}
//			return b;
//
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);

	}

}
