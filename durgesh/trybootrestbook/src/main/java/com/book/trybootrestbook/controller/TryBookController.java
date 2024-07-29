package com.book.trybootrestbook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.trybootrestbook.model.Book;
import com.book.trybootrestbook.service.TryBookService;

@RestController
public class TryBookController {

	@Autowired
	private TryBookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return this.bookService.getAllBooks();
	}
	
	
	// get single book try
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable ("id") int id) {
		
		return bookService.getBookById(id);
	}
	
	// add book 
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}
	
	
}
