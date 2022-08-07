package it.projects.catalogue;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Prestito {
	
	@ManyToOne
	User user;
	
	
	@ManyToOne
	AbstractCatalogo elePrestato;
	LocalDate dataInizio;
	LocalDate dataFinePrevista;
	LocalDate dataFineEffettiva;
	@Id
	@SequenceGenerator(name = "prestito_seq", sequenceName = "prestito_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestito_seq")
	private long id;
	public Prestito(User user, AbstractCatalogo elePrestato, LocalDate dataInizio, LocalDate dataFinePrevista,
			LocalDate dataFineEffettiva) {
		
		this.user = user;
		this.elePrestato = elePrestato;
		this.dataInizio = dataInizio;
		this.dataFinePrevista = dataInizio.plusDays(30);
		this.dataFineEffettiva = dataFineEffettiva;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AbstractCatalogo getElePrestato() {
		return elePrestato;
	}
	public void setElePrestato(AbstractCatalogo elePrestato) {
		this.elePrestato = elePrestato;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFinePrevista() {
		return dataFinePrevista;
	}
	public void setDataFinePrevista(LocalDate dataFinePrevista) {
		this.dataFinePrevista = dataFinePrevista;
	}
	public LocalDate getDataFineEffettiva() {
		return dataFineEffettiva;
	}
	public void setDataFineEffettiva(LocalDate dataFineEffettiva) {
		this.dataFineEffettiva = dataFineEffettiva;
	}
	
	
}
