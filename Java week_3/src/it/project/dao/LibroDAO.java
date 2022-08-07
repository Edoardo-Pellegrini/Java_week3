package it.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.projects.catalogue.User;
import it.projects.catalogue.book.Libro;
import it.projects.catalogue.util.JPAutil;

public class LibroDAO {
	private static final Logger logger = LoggerFactory.getLogger(LibroDAO.class);
	public void save(Libro a) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }
	public void refresh(Libro object) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }
    }

    public Libro getById(long id) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(Libro.class, id);

        } finally {
            em.close();
        }
    }

    public void delete(Libro object) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {
        	
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            //em.remove(object);
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
//	public void save(BookImp object) {
//		EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
////		try {
//
//			EntityTransaction transaction = em.getTransaction();
//			transaction.begin();
//
//			em.persist(object);
//
//			transaction.commit();
////		} catch (Exception ex) {
////			em.getTransaction().rollback();
////
////			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
////			throw ex;
////
////		} finally {
////			em.close();
////		}
//
//	}
}
