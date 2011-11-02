package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Authorized extends Controller {
    
	 @Before
     static void setConnectedUser() {
         if(Security.isConnected()) {
			 System.out.println("Connected " + Security.connected());
             Author author = Author.find("byEmail", Security.connected()).first();
             if(author != null){
				renderArgs.put("authorId", author.id);
			 }
         }
     }

	
	public static void myPage() {
        Author author = Author.find("byEmail", Security.connected()).first();
		render(author);
	}
	
	// Only renders creation
	public static void createBook() { render(); }
	
	public static void saveBook(String title, String synopsis) {
		validation.required(title);
		validation.required(synopsis);
		if(validation.hasErrors()) {
			params.flash(); // add http parameters to the flash scope
		    validation.keep(); // keep the errors for the next request
			createBook();
        }
		
		
		Author author = Author.find("byEmail", Security.connected()).first();
		Book book = new Book();
		book.title = title;
		book.synopsis = synopsis;
		author.books.add(book);
		author.save();
		viewBook(book.id);
	}
	
	public static void viewBook(Long bookId) {
		Book book = Book.findById(bookId);
		render(book);
	}
	

}

