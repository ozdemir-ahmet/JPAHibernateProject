package be.ozdemir.schoolsout.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("datasource");
    }
    public static EntityManager createEM (){
        return emf.createEntityManager();
    }
}
