package it.projects.catalogue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractCatalogo {
	// Attributi da condiv. tra sottoclassi
	@Id 
	@SequenceGenerator(name = "abstract_seq", sequenceName = "abstract_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abstract_seq")
	private long id ;
	private String isbn;
	private String title;
	private int year;
	private int pages;
	
	// Generate constructor using fields
	public AbstractCatalogo(String isbn, String title, int year, int pages) {
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.pages = pages;
	}
	
	public AbstractCatalogo() {
		// TODO Auto-generated constructor stub
	}

	// === Getters ===
	public String getIsbn() { return isbn; }
	public String getTitle() { return title; }	
	public int getYear() { return year; }	
	public int getPages() { return pages; }
	
	// === Setters ===
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setTitle(String title) { this.title = title; }
	public void setYear(int year) { this.year = year; }
	public void setPages(int pages) { this.pages = pages; }

	// Auto generare toString. Source --> Generate toString()
	@Override
	public String toString() {
		return "ISBN: " + isbn + ", title: " + title + ", year: " + year + ", pages: " + pages;
	}
	
	
}
