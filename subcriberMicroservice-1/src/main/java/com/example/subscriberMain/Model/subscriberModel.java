package com.example.subscriberMain.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscriberTable")
public class subscriberModel {
	
	public subscriberModel() 
	{
		super();	
	}
	public subscriberModel(int subscriberId, String subscriberName, long issueBookId,List<book> bookDet) 
	{
		super();
		this.subscriberId=subscriberId;
		this.subscriberName=subscriberName;
		this.issueBookId=issueBookId;
	}
	public subscriberModel(int subscriberId, String subscriberName, long issueBookId) 
	{
		super();
		this.subscriberId=subscriberId;
		this.subscriberName=subscriberName;
		this.issueBookId=issueBookId;
		
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriberId;
	
	public void setSubscriberId(int subscriberId) 
	{
		this.subscriberId=subscriberId;
	}
	
	@Column(name="subcriberName")
	private String subscriberName;
	
	@Column(name="subscriberIssueBookId")
	private long issueBookId;
   
	public int getSubscriberId() 
	{
		return this.subscriberId;
	}
	public void setSubscriberName(String subscriberName) 
	{
		this.subscriberName=subscriberName;
	}
	public String getSubscriberName() 
	{
		return this.subscriberName;
	}
	public void setIssueBookId(long issueBookId) 
	{
		this.issueBookId=issueBookId;
	}
	public long getIssueBookInt() 
	{
		return this.issueBookId;
	}
	
	public String toString() 
	{
		return "student Details [subscriberId "+this.subscriberId+", subscriberName "+this.subscriberName+",issueBookId "+this.issueBookId+"]";
	}

}
