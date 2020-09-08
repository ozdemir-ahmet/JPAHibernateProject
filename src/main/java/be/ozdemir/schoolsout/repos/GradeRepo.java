package be.ozdemir.schoolsout.repos;

import be.ozdemir.schoolsout.model.Grade;
import be.ozdemir.schoolsout.model.User;
import be.ozdemir.schoolsout.utils.EntityManagerCreator;
import be.ozdemir.schoolsout.utils.TransactionException;

import javax.persistence.EntityManager;
import java.util.Optional;

public class GradeRepo {
    public Optional<Grade> getGradeById (Long id) {
        EntityManager em = EntityManagerCreator.createEM();
        Grade grade = em.find(Grade.class,id);
        if (grade != null){
            return Optional.of(grade);
        }
        return Optional.empty();
    }

    public Boolean insertGrade (Grade grade){
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        em.persist(grade);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public Grade updateGrade (Grade grade){
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        if (getGradeById(grade.getId()).isEmpty()) {
            System.out.println(grade.getId() + " is inserted into the database");
            grade = em.merge(grade);
            em.getTransaction().commit();
            em.close();
            return grade;
        } else {
            System.out.println(grade.getId() + " is updated");
            grade = em.merge(grade);
            em.getTransaction().commit();
            em.close();
            return grade;
        }
    }

    public Optional<Grade> deleteGrade (Grade grade) throws TransactionException {
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        if (getGradeById(grade.getId()) == null){
            throw new TransactionException ("No such user found to be removed");
        } else {
            em.remove(grade);
            return Optional.of(grade);
        }
    }
}
