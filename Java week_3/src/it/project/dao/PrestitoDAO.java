package it.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.projects.catalogue.AbstractCatalogo;
import it.projects.catalogue.Prestito;
import it.projects.catalogue.User;
import it.projects.catalogue.util.JPAutil;

public class PrestitoDAO {
	private static final Logger logger = LoggerFactory.getLogger(PrestitoDAO.class);

	public void save(Prestito a) {
		prestiti.add(a);
		EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	public void refresh(Prestito object) {
		EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}
	}

	public Prestito getById(Long id) {
		EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Prestito.class, id);

		} finally {
			em.close();
		}
	}

	public void delete(Prestito object) {
		EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	private ArrayList<Prestito> prestiti = new ArrayList<>();

	public void searchByCodiceTessera(int id) {
		prestiti.stream()

				.filter(ele -> ele.getUser().getCodiceTessera() == id).filter(ele -> ele.getDataFineEffettiva() == null)
				.forEach(ele -> System.out.println("@@@@@@@@@ Prestiti utente " + ele.getUser().getNome() + " "
						+ ele.getUser().getCognome() + ": " + ele.getElePrestato()));
	}

	public void searchPrestitiScaduti() {
		prestiti.stream().filter(ele -> ele.getDataFineEffettiva() != null)
				.filter(ele -> ele.getDataFineEffettiva().isAfter(ele.getDataFinePrevista()) == true)
				.forEach(ele -> System.out.println("@@@@@@@@@ Prestito scaduto : " + ele.getUser().getNome() + " "
						+ ele.getUser().getCognome() + ": " + ele.getElePrestato()));
	}
}
