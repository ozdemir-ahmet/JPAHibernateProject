package be.ozdemir.schoolsout.view;

import be.ozdemir.schoolsout.Utils.EntityUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManager em = EntityUtils.createEM();

    }
}
