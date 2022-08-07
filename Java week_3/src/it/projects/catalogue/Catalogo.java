package it.projects.catalogue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.persistence.Entity;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.projects.catalogue.book.Libro;

public class Catalogo implements Icatalogo {
	// contenitore metodi catalogo
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	public Catalogo() {
		super();
	}

	// tipizzare collection del tipo classe astratta per racchiudere diversi tipi di sottoclassi
	private HashMap<String, AbstractCatalogo> Database = new HashMap<>();
	
	public void size() {
		log.info("N. of books/magazines in Catalogue: " + Database.size()); 
	}
	
	@Override
	public void addElement(String codIsbn, AbstractCatalogo obj) {
		Database.put(codIsbn, obj);
		log.info("Object Successfully added!");
	}

	@Override
	public void removeByIsbn(String codIsbn) {
		Database.remove(codIsbn);
		log.info("Object Successfully removed!");
	}

	@Override
	public void searchByIsbn(String codIsbn) {
		// restituisce chiave inerente all'oggetto
		log.info("Search By ISBN --> " + Database.get(codIsbn));	
	}

	@Override
	public void searchByTitle(String title) {
		Database.values().stream()
		.filter(ele -> ele.getTitle() == title)
		.forEach(ele -> log.info("Search By Title --> " + ele.toString()));		
	}
	
	@Override
	public void searchByYear(int year) {	
		// prendo valori del database, .stream (= a .subscribe())
		Database.values().stream()
			// filtro ogni elemento nel database in base all'anno
			.filter(ele -> ele.getYear() == year)
			// stampa le info in base alla ricerca per anno
			.forEach(ele -> log.info("Search By Year --> " + ele.toString()));
	}

	@Override
	public void searchByAuthor(String author) {
		Database.values().stream()
			.filter(ele -> ele instanceof Libro)
				
				.map(ele -> (Libro)ele)
				
				.filter(ele -> author.equals(ele.getAuthor()))
				.forEach(ele -> log.info("Search By Author --> " + ele.toString()));
	}

	@Override
	public void searchByGenre(String genre) {
		Database.values().stream()
		.filter(ele -> ele instanceof Libro)
			.map(ele -> (Libro)ele)
			.filter(ele -> genre.equals(ele.getGenre()))
			.forEach(ele -> log.info("Search By Genre --> " + ele.toString()));
	}

	@Override
	public void saveOnDisk() {				
		File myObj = new File("fileText/database.txt");
		log.info("****File Save successfull!****");
		String text = ""; 
		
		for (AbstractCatalogo ele : Database.values()) {
			text += ele.toString();		
		}		
		
		try { FileUtils.writeStringToFile(myObj, text, "UTF-8"); } 
		catch (IOException e) { e.printStackTrace(); }			
	}

	@Override
	public void loadFromDisk() {
			
		try { 
			String fileCont = FileUtils.readFileToString(new File("fileText/database.txt")); 
			log.info("****File Load successfull!****");
			log.info(fileCont);
		} 
		catch (IOException e) { e.printStackTrace(); }		
	}

}
