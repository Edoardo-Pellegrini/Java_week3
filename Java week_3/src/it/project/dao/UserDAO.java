package it.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.projects.catalogue.User;
import it.projects.catalogue.magazine.Rivista;
import it.projects.catalogue.util.JPAutil;

public class UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	public void save(User a) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }
	

    public void refresh(User object) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }
    }

    public User getById(Long id) {
        EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(User.class, id);

        } finally {
            em.close();
        }
    }

    public void delete(User object) {
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
}
