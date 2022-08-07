package it.projects.catalogue.magazine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import it.projects.catalogue.AbstractCatalogo;
import it.projects.catalogue.Periodicity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Rivista extends AbstractCatalogo {
	
	private Periodicity periodicity;
	
	

	public Rivista(String isbn, String title, int year, int pages, Periodicity periodicity) {
		super(isbn, title, year, pages);
		this.periodicity = periodicity;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		// dati da riportare nel logger tramite il main
		return periodicity + " Magazine, " + super.toString() + ". ";
	}

}
