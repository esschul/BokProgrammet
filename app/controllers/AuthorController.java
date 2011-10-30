package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class AuthorController extends Controller {

	public static void create(String email, String password, String name) {
		Author author = new Author(email, password, name);
		if(author.save() != null){
			Author connected = author.connect(email, password);
			if(connected != null){
				myPage(connected.id);				
			};
		} else {
			Application.index();			
		}
	}
	
	public static void myPage(Long id) {
		Author author = Author.findById(id);
		render(author);
	}

}

