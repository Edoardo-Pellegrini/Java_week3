package it.projects.catalogue;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Iterator;

import it.project.dao.LibroDAO;
import it.project.dao.RivistaDAO;
import it.project.dao.PrestitoDAO;
import it.project.dao.UserDAO;
import it.projects.catalogue.book.Libro;
import it.projects.catalogue.magazine.Rivista;

public class Main {

	public static void main(String[] args) {
		// qui istanzio oggetti e faccio test console
		Libro book1 = new Libro("8804512156", "Poeta al comando", 2003, 256, "Alessandro Barbero", "Storico-Medievale");
		Libro book2 = new Libro("0747532699", "Harry Potter and the Philosopher's Stone", 1997, 223, "J. K. Rowling", "Fantasy");
		Libro book3 = new Libro("6543543654", "Gianfrancoo la vendetta", 1990, 345, "J. K. Rowling", "Fantasy");
		Rivista mag1 = new Rivista("9780847833580", "Time", 2010, 150, Periodicity.WEEKLY);
//		BookImp book3 = saveBook();
//		MagazineImp mag2 = saveMagazine();
		// referenza catalogo per accedere ai metodi
//		CatalogueDatabase database = new CatalogueDatabase();
//		
//		database.addElement(book1.getIsbn(), book1);
//		database.addElement(book2.getIsbn(), book2);
//		database.addElement(mag1.getIsbn(), mag1);
//		database.size();
//				
//		database.searchByIsbn("8804512156");
//		database.searchByTitle("Harry Potter and the Philosopher's Stone");
//		database.searchByYear(2003);
//		database.searchByAuthor("J. K. Rowling");
//		database.searchByGenre("Storico-Medievale");
//		
//		database.saveOnDisk();
//		database.loadFromDisk();
//		
//		// ===============================================
//		
//		database.removeByIsbn("8804512156");
//		database.size();
		LibroDAO bookDAO = new LibroDAO();
		bookDAO.save(book2);
		bookDAO.save(book3);
		bookDAO.save(book1);
		RivistaDAO magazineDAO = new RivistaDAO();
		magazineDAO.save(mag1);
		
		User franco = new User("Franco","Berghi",1984,37485731);
		User maria = new User("Maria","Gesuita",1987,37485962);
		UserDAO userDAO = new UserDAO();
		
		userDAO.save(franco);
		userDAO.save(maria);
		
		//franco.getUser().add(franco);
		
		Prestito prestito = new Prestito(franco,book1,LocalDate.now(),LocalDate.now(),null);
		
		Prestito prestito3 = new Prestito(franco,book3,LocalDate.now(),LocalDate.now(),null);
		Prestito prestito4 = new Prestito(maria,mag1,LocalDate.now(),LocalDate.now(),null);
//		prestito.setDataFineEffettiva(LocalDate.now().plusDays(25));
//		prestito3.setDataFineEffettiva(LocalDate.now().plusDays(10));
		
		Prestito prestito2 = new Prestito(maria,book2,LocalDate.now(),LocalDate.now(),null);
		
		prestito2.setDataFineEffettiva(LocalDate.now().plusDays(40));
		
		PrestitoDAO prestitoDAO = new PrestitoDAO();
		
		prestitoDAO.save( prestito);
		prestitoDAO.save(prestito2);
		prestitoDAO.save(prestito3);
		prestitoDAO.save(prestito4);
		System.out.println("******"+bookDAO.getById(1)+"******");
//		bookDAO.delete(book1);
		
		prestitoDAO.searchByCodiceTessera(37485731);
		prestitoDAO.searchByCodiceTessera(37485962);
		prestitoDAO.searchPrestitiScaduti();
		
		

		System.out.println("***********************************************************************");
		
//		magazineDAO.refresh(mag1);
		
//		magazineDAO.delete(mag1);
//		bookDAO.getById((long)1);
		
	}

//	private static void saveBook() {
//		BookImp book = new BookImp("8804512156", "Poeta al comando", 2003, 256, "Alessandro Barbero", "Storico-Medievale");
//		BookDAO bookDAO = new BookDAO();
//		bookDAO.save(book);
//		
//		
//	}
//	private static MagazineImp saveMagazine() {
//		MagazineImp mag2 = new MagazineImp("9780847833580", "Time", 2010, 150, Periodicity.WEEKLY);
//		MagazineDAO magDAO = new MagazineDAO();
//		magDAO.save(mag2);
//		return mag2;
//	}
	

}
