package com.example.subscriberMain.services;
import com.example.subscriberMain.Model.subscriberModel;
import com.example.subscriberMain.subcribeRepository.subscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class subscriberServices {
	
	@Autowired subscriberRepository repository;
	
	public List<subscriberModel> getSubcriber()
	{
		return repository.findAll();
	}
	public subscriberModel getSpecificSubscriber(int subscriberId) 
	{
		return repository.findById(subscriberId).get();
	}
//	public void postSubscriber(subscriberModel subscriber ) 
//	{
//		repository.save(subscriber);
//	}
	public subscriberModel postSubscriber(subscriberModel subscriber ) 
	{
		return repository.save(subscriber);
	}
	public void subscriberRemoveById(int subscriberId) 
	{
		repository.deleteById(subscriberId);
	}
	public void updateUserDetails(subscriberModel userDetails) {
		repository.save(userDetails);
		
	}
	

}
