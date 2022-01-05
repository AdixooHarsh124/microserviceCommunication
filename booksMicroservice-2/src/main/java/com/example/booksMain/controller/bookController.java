package com.example.booksMain.controller;
import com.example.booksMain.Model.bookModel;
import com.example.booksMain.services.bookServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class bookController {
	
	@Autowired bookServices service;
	
	@Autowired 
	private RestTemplate rest;
	
	@GetMapping("/totelBooks")
	public List<bookModel> allBooks()
	{
		return service.getAllBooks();
	}
	
	
	
	@GetMapping("/book/{bookId}")
	public bookModel oneBookDetails(@PathVariable("bookId") int bookId)
	{
		return service.getSpecificBookDetails(bookId);
	}
	
	@PostMapping("/addNewBook")
	public void addBook(@RequestBody bookModel newBook) 
	{
		service.addNewBook(newBook);
	}
	
	@DeleteMapping("/removeOne/{bookId}")
	public void removeOne(@PathVariable("bookId") int bookId) 
	{
		service.removeOne(bookId);
	}
    
	@PutMapping("/updateDetails/{bookId}")
	public void updateBookDetails(@RequestBody bookModel book,@PathVariable("bookId") int bookId) 
	{
		bookModel bookDetails=service.getSpecificBookDetails(bookId);
		bookDetails.setAuthorName(book.getAuthorName());
		bookDetails.setBookName(book.getBookName());
		bookDetails.setRemainingBooks(book.getRemainingBooks());
		bookDetails.setTotelNumberOfCopies(book.getTotelNumberOfCopies());
		service.updateDetails(bookDetails);
	}
}
