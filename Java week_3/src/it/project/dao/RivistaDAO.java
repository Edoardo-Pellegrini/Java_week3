package it.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.projects.catalogue.User;
import it.projects.catalogue.book.Libro;
import it.projects.catalogue.magazine.Rivista;
import it.projects.catalogue.util.JPAutil;

public class RivistaDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(RivistaDAO.class);
	public void save(Rivista a) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }
	public void refresh(Rivista object) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }
    }

    public Rivista getById(long id) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(Rivista.class, id);

        } finally {
            em.close();
        }
    }

    public void delete(Rivista object) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(em.contains(object) ? object : em.merge(object));

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

}
