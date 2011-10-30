package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class BookController extends Controller {

	public static void create(Long authorId) {
		render(authorId);
	}
	
	public static void save(Long authorId, String title, String synopsis) {
		Book book = new Book();
		book.title = title;
		book.synopsis = synopsis;
		Author author = Author.findById(authorId);
		author.books.add(book);
		author.save();
		view(authorId,book.id);
	}
	
	public static void view(Long authorId,Long bookId) {
		Author author = Author.findById(authorId);
		Book book = Book.findById(bookId);
		render(author,book);
	}
    
}

