package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity(name="author")
public class Author extends Model {
	
	public String name;

    @Email
    @Required
    public String email;
	
	@Required
	public String password;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    public List<Book> books;
	
	public Author(String email, String password, String name) {
	        this.email = email;
	        this.password = password;
	        this.name = name;
	}

	public static Author connect(String email, String password) {
		List<Author> authors = find("byEmailAndPassword", email, password).fetch();
		 System.out.println(authors.get(0)); 
		 System.out.println("Found : " + authors.size());
	     return find("byEmailAndPassword", email, password).first();
	}


	public String toString() { return email; }
	    
}