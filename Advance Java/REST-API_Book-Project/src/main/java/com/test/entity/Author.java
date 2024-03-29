package com.test.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

//@Entity
//public class Author {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int authorId;
//	private String authorName;
//	
////	for bidirectinal mapping
//	@OneToOne(mappedBy = "author")
//	private Books book;
//	
//
//	public Books getBook() {
//		return book;
//	}
//
//	public void setBook(Books book) {
//		this.book = book;
//	}
//
//
//	public int getAuthorId() {
//		return authorId;
//	}
//
//	public void setAuthorId(int authorId) {
//		this.authorId = authorId;
//	}
//
//	public String getAuthorName() {
//		return authorName;
//	}
//
//	public void setAuthorName(String authorName) {
//		this.authorName = authorName;
//	}
//
//	@Override
//	public String toString() {
//		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
//	}
//
//	public Author(int authorId, String authorName) {
//		super();
//		this.authorId = authorId;
//		this.authorName = authorName;
//	}
//
//	public Author() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//}
