package com.example.subscriberMain.utility;

import java.util.List;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.subscriberMain.Model.book;
//@FeignClient( name="")
public interface FeignClientUtility {

	@GetMapping("/{id}")
	public book getBookById(@PathVariable("id") int id);
	
	@PutMapping("/{bookId}")
	public book updateBookById(@PathVariable("bookId") int id, @RequestBody book bookModel);
	
	@GetMapping("")
	public List<book> getAllBook();
}
