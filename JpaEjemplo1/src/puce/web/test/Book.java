package puce.web.test;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	private String name;
	
	//union many to one
	@ManyToOne
	@JoinColumn
	private BookCategory bookCategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	
}
