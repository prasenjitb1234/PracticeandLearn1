package com.book.trybootrestbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.book.trybootrestbook.model.Book;

@Service
public class TryBookService {
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(1,"Java complete ref","abc"));
		list.add(new Book(2,"Python complete ref","def"));
		list.add(new Book(3,"C++ complete ref","ghi"));
		
	}
	
	
	// creating service - get all books 
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	
	// creating service - to get single book 
	
	
	public Book getBookById(int id) {
		Book book = null;
		for (Book currentBook : list) {
	        if (currentBook.getId() == id) {
	            book = currentBook;
	            break;  // Exit the loop once the book is found
	        }
	    }
		return book;
	}
	
	
	// creating service to add books
		
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	// delete a book 
	
	
	
	
	
	
}