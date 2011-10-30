package models;

import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;
import play.data.validation.*;

@Entity(name="book")
public class Book extends Model {
	
	public String title = "Untitled project";

    @Column(length = 5000)
	public String synopsis = "Nothing here yet.";

	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Chapter> chapters = new LinkedList<Chapter>();

	@ManyToMany(mappedBy="books")
	public List<Author> authors = new LinkedList<Author>();

	public BookStatus status = BookStatus.DRAFT;

	public String toString() { return title; }
	
	public enum BookStatus {
		DRAFT,REVIEW,PUBLISHED;
	}
	
}


