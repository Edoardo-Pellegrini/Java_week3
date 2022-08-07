package it.projects.catalogue;

public interface Icatalogo {

	// === Servizi Database (key: codIsbn, value: object) ===
	void addElement(String codIsbn, AbstractCatalogo obj);

	void removeByIsbn(String codIsbn);

	void searchByIsbn(String codIsbn);
	
	void searchByTitle(String title);

	void searchByYear(int year);
	
	void searchByAuthor(String author);
	
	void searchByGenre(String genre);

	void saveOnDisk();

	void loadFromDisk();

}