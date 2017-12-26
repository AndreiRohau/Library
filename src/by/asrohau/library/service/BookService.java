package by.asrohau.library.service;

import by.asrohau.library.bean.Book;

public interface BookService {

	boolean validation(String title, String author);
	boolean addBook(String title, String author);
	Book[] findBookWithTitle(String title);
	Book[] findBookWithAuthor(String author);
	
}
