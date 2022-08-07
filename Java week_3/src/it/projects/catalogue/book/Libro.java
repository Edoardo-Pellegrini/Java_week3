package it.projects.catalogue.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import it.projects.catalogue.AbstractCatalogo;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Libro extends AbstractCatalogo {
	public Libro(String isbn, String title, int year, int pages) {
		super(isbn, title, year, pages);
	}

	// classi concrete con cui andro' ad istanziare oggetti
	
	
	
	

	// attributi esclusivi classe BookImp
	private String author;
	public Libro() {
		super();
	}

	private String genre;
	

	// attributi ereditati
	public Libro(String isbn, String title, int year, int pages, String author, String genre) {
		super(isbn, title, year, pages);
		this.author = author;
		this.genre = genre;
	}
	
	// === Getters ===
	public String getAuthor() {	return author; }
	public String getGenre() { return genre; }
	
	// === Setters ===
	public void setAuthor(String author) { this.author = author; }
	
	
	
	public void setGenre(String genre) { this.genre = genre; }

	@Override
	public String toString() {
		// dati da riportare nel logger tramite il main
		return "Book " + super.toString() + ", author: " + author + ", genre: " + genre + ". ";
	}

	
	
}
