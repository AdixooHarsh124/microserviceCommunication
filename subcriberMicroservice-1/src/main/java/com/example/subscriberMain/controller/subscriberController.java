package com.example.subscriberMain.controller;

import com.example.subscriberMain.services.subscriberServices;
import com.example.subscriberMain.Model.book;
import com.example.subscriberMain.Model.subscriberModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class subscriberController {

	@Autowired 
	subscriberServices service;
	
	@Autowired 
	RestTemplate rest;
	
	@GetMapping("/allSubscriber")
	public ResponseEntity<List<subscriberModel>> getAllSubcriber() 
	{
		List<subscriberModel> list=service.getSubcriber();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/specificSubscriber/{subscriberId}")
	public ResponseEntity<subscriberModel> getSubscriberById(@PathVariable("subscriberId") int subscriberId ) 
	{
        subscriberModel subscriber=service.getSpecificSubscriber(subscriberId);
		 
		 if(subscriber == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(subscriber));
	}
	
	@PostMapping("/subscriberAdd")
	public ResponseEntity<subscriberModel> saveSubcriber(@RequestBody subscriberModel subcriber) 
	{
		book books=rest.getForObject("http://localhost:3001/book/"+subcriber.getIssueBookInt(),book.class);
		System.out.println(books);
		if(books.getRemainingBooks() != 0 && books.getTotelNumberOfCopies() >= books.getRemainingBooks()) 
		{
			System.out.println("condition matched");
			try {
			subscriberModel model=service.postSubscriber(subcriber);
			System.out.println(model);
			int remainingBooks=books.getRemainingBooks();
			remainingBooks--;
			
			books.setRemainingBooks(remainingBooks);
			rest.put("http://localhost:3001/updateDetails/"+subcriber.getIssueBookInt(), books);
			return ResponseEntity.status(HttpStatus.OK).build();
			
			}catch (Exception e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.valueOf("No books Available")).build();	
		}
	}
	
	@DeleteMapping("/removeSubscriber/{subscriberId}")
	public ResponseEntity<subscriberModel> removeSubscriber(@PathVariable("subscriberId") int subscriberId)
	{
	    subscriberModel subscriberDetails=new subscriberModel();
	    System.out.println("delete condition");
		
		try {
			
			subscriberDetails=service.getSpecificSubscriber(subscriberId);
			book book=this.rest.getForObject("http://localhost:3001/book/"+ subscriberDetails.getIssueBookInt(),book.class);
			
			int availableBooks=book.getRemainingBooks();
			availableBooks++;
			
			book.setRemainingBooks(availableBooks);
			rest.put("http://localhost:3001/updateDetails/"+ subscriberDetails.getIssueBookInt(), book);
				
				
				service.subscriberRemoveById(subscriberId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/updateSubscriber/{subscriberId}")
	public void updateUserDetails(@RequestBody subscriberModel subscriber,@PathVariable("subscriberId") int subscriberId)
	{
	   subscriberModel userDetails=service.getSpecificSubscriber(subscriberId);
	   userDetails.setSubscriberName(subscriber.getSubscriberName());
	   userDetails.setIssueBookId(subscriber.getIssueBookInt());
	   service.updateUserDetails(userDetails);
	}
	
}
