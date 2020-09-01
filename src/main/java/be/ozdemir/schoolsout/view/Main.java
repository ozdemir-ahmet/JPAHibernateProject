package be.ozdemir.schoolsout.view;

import be.ozdemir.schoolsout.Utils.EntityManagerFactoryCreator;
import be.ozdemir.schoolsout.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactoryCreator.createEMF();
        EntityManager em = emf.createEntityManager();

    }
}
