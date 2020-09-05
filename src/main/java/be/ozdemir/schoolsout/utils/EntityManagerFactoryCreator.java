package be.ozdemir.schoolsout.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryCreator {
    public static EntityManagerFactory createEMF (){
        return Persistence.createEntityManagerFactory("datasource");
    }
}
