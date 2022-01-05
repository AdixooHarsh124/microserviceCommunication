package com.example.booksMain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booksMain.Model.bookModel;
import com.example.booksMain.repository.bookRepository;

@Service
public class bookServices {

	@Autowired bookRepository repository;
	
	public List<bookModel> getAllBooks()
	{
		return repository.findAll();
	}
	
	public bookModel getSpecificBookDetails(int bookId) 
	{
		return repository.findById(bookId).get();
	}
	
	public void addNewBook(bookModel addOne) 
	{
		repository.save(addOne);
	}
	
	public void removeOne(int bookId) 
	{
		repository.deleteById(bookId);
	}
	public void updateDetails(bookModel book) 
	{
		repository.save(book);
	}
}
