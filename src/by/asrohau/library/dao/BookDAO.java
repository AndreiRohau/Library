package by.asrohau.library.dao;

import by.asrohau.library.bean.Book;

public interface BookDAO {

	Book findBook(String title, String author);

	boolean saveBook(String title, String author);
	
	Book[] findBookWithTitle(String title);
	
	Book[] findBookWithAuthor(String author);
}
