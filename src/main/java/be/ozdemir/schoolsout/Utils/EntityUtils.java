package be.ozdemir.schoolsout.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityUtils {
    static EntityManagerFactory emf;
    private static void createEMF (){
        emf = Persistence.createEntityManagerFactory("datasource");
    }

    public static EntityManager createEM () {
        createEMF();
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
