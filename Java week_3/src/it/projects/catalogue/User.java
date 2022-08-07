package it.projects.catalogue;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	@Id
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private long id;
	private String nome;
	private String cognome;
	private int annoNascita;
	@OneToMany
	private Set<Prestito>prestiti;
	
	private int codiceTessera;
	
	
	
	@Override
	public String toString() {
		return "User [getId()=" + getId() + ", getPrestiti()=" + getPrestiti() + ", getNome()=" + getNome()
				+ ", getCognome()=" + getCognome() + ", getAnnoNascita()=" + getAnnoNascita() + ", getCodiceTessera()="
				+ getCodiceTessera() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	
	public Set<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	public User(String nome, String cognome, int annoNascita, int codiceTessera) {

		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.codiceTessera = codiceTessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}

	public int getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(int codiceTessera) {
		this.codiceTessera = codiceTessera;
	}
	
}
