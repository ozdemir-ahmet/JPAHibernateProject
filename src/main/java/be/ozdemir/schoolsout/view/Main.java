package be.ozdemir.schoolsout.view;

import be.ozdemir.schoolsout.utils.EntityManagerFactoryCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactoryCreator.createEMF();
        EntityManager em = emf.createEntityManager();

    }
}
