package org.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    // Crea una Factory ocupando el configurado en persistence.xml;
    // Lo llamamos con el name establecido.
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
