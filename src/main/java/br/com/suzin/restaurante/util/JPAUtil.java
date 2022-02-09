package br.com.suzin.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory SFOOD = Persistence.createEntityManagerFactory("sFood");

    public static EntityManager getEntityManagerSFood() {
        return SFOOD.createEntityManager();
    }
}
