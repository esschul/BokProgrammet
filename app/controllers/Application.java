package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
		List<Book> books = Book.all().fetch(30);
   		render(books);
    }

}