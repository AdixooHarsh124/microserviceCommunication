package com.example.booksMain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookList")
public class bookModel {
	
	public bookModel() {
		super();
	}

	public bookModel(int bookId, String bookName, String authorName, int totelNumberOfCopies, int remainingBooks) {
		super();
		this.bookId = bookId;
		this.AuthorName = authorName;
		this.bookName = bookName;
		this.totelNumberOfCopies = totelNumberOfCopies;
		this.remainingBooks = remainingBooks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@Column
	private String AuthorName;
	
	@Column
	private String bookName;
	
	@Column
	private int totelNumberOfCopies;
	
	@Column
	private int remainingBooks;
	
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
