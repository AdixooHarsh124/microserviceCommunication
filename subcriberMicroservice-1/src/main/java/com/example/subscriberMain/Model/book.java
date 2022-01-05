package com.example.subscriberMain.Model;

public class book {
	

	private int bookId;
	private String AuthorName;
	private String bookName;
	private int totelNumberOfCopies;
	private int remainingBooks;
	public book() {
		super();
	}

	public book(int bookId, String bookName, String authorName, int totelNumberOfCopies, int remainingBooks) {
		super();
		this.bookId = bookId;
		this.AuthorName = authorName;
		this.bookName = bookName;
		this.totelNumberOfCopies = totelNumberOfCopies;
		this.remainingBooks = remainingBooks;
	}

		
	
	public book(int remainingBooks2) {
		this.remainingBooks=remainingBooks2;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getTotelNumberOfCopies() {
		return totelNumberOfCopies;
	}

	public void setTotelNumberOfCopies(int totelNumberOfCopies) {
		this.totelNumberOfCopies = totelNumberOfCopies;
	}

	public int getRemainingBooks() {
		return remainingBooks;
	}

	public void setRemainingBooks(int remainingBooks) {
		this.remainingBooks = remainingBooks;
	}
	

	@Override
	public String toString() {
		return "bookModel [bookId=" + bookId + ", bookName=" + bookName + ", AuthorName=" + AuthorName
				+ ", totelNumberOfCopies=" + totelNumberOfCopies + ", remainingBooks=" + remainingBooks + "]";
	}
	}


