package puce.web.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.FetchMode;

import org.hibernate.annotations.Fetch;

@Entity
public class BookCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	//union one to many
	@OneToMany(mappedBy = "bookCategory", fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval=true)//uniendo
	private Set<Book> books = new HashSet<Book>();

	public String getName() {
		
		return name;

	}

	public void setName(String name) {
	this.name = name;

	}
	public Set<Book> getBooks() {

	return books;

	}
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}