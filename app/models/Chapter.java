package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Chapter extends Model {
	
	public String title;
	public String text;
	
	@ManyToOne
	public Book book;
	
	public String toString() { return title; }
	
}

