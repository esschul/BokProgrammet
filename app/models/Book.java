package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book extends Model {
	
	public String title = "Untitled project";

	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Chapter> chapters;

	@ManyToMany(mappedBy="books")
	public List<Author> authors;

	public BookStatus status = BookStatus.DRAFT;

	public String toString() { return title; }
	
	public enum BookStatus {
		DRAFT,REVIEW,PUBLISHED;
	}
	
}


