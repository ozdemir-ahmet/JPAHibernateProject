package be.ozdemir.schoolsout.repos;

import be.ozdemir.schoolsout.model.Person;
import be.ozdemir.schoolsout.model.User;
import be.ozdemir.schoolsout.utils.EntityManagerCreator;
import be.ozdemir.schoolsout.utils.TransactionException;

import javax.persistence.EntityManager;
import java.util.Optional;

public class PersonRepo {
    public Optional<Person> getPersonById (Integer id){
        EntityManager em = EntityManagerCreator.createEM();
        Person person = em.find(Person.class, id);
        if (person != null) {
            return (Optional.of(person));
        }
        return (Optional.empty());
    }

    public void insertPerson (Person person){
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public Person updatePerson (Person person){
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        if (getPersonById(person.getId()).isEmpty()) {
            System.out.println(person.getId() + " is inserted into the database");
            person = em.merge(person);
            em.getTransaction().commit();
            em.close();
            return person;
        } else {
            System.out.println(person.getId() + " is updated");
            person = em.merge(person);
            em.getTransaction().commit();
            em.close();
            return person;
        }
    }

    public Optional<Person> deletePerson (Person person) throws TransactionException {
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        if (getPersonById(person.getId()) == null){
            throw new TransactionException ("No such person found to be removed");
        } else {
            em.remove(person);
            return Optional.of(person);
        }
    }
}
