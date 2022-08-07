package it.projects.catalogue.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
    private static final Logger logger = LoggerFactory.getLogger(JPAutil.class);


    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence
                    .createEntityManagerFactory("JavaWeek3");
        } catch (Throwable ex) {
            logger.error("Initial EntityManagerFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
