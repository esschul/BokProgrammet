package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Unauthorized extends Controller {

    public static void index() {
		List<Book> books = Book.all().fetch(30);
   		render(books);
    }

	public static void register(String email, String password, String name) {
		System.out.println("New user request: " + email + ". Name:" + name);
		Author author = new Author(email, password, name);
		author.save();
		if(author.id != null){
			Author connected = author.connect(email, password);
			if(connected != null){
				Authorized.myPage();				
			};
		} else {
			Unauthorized.index();			
		}
	}

}