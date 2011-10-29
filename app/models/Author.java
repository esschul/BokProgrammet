package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity(name="authors")
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
	        return find("byEmailAndPassword", email, password).first();
	}


	public String toString() { return email; }
	    
}