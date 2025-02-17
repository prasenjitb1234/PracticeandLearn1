package com.api.book.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

//	@RequestMapping(value="/books",method=RequestMethod.GET)
//	@ResponseBody

//	@GetMapping("/books")
//	public Book getBooks() {
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("Wings of fire");
//		book.setAuthor("APJ Abdul Kalam");
//		
//		
//		
//		return book;
//		
//	}

//	*************

	@Autowired
	private BookService bookService;

	// get all books

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {

		List<Book> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(list);

	}

	// get single book handler

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// create new - adding book

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			System.out.println(book);
//			return ResponseEntity.status(HttpStatus.CREATED).build();
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	// delete book handler
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	////

//	update book handler 



	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
	    try {
	        // Call the service method to update the book
	        this.bookService.updateBook(book, bookId);
	        
	        // Return a 200 OK response with the updated book
	        return ResponseEntity.ok(book);
	    } catch (Exception e) {
	        // Print stack trace for debugging
	        e.printStackTrace();
	        
	        // Return a 500 Internal Server Error response
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	
	
	
}
