package be.ozdemir.schoolsout.repos;

import be.ozdemir.schoolsout.utils.EntityManagerCreator;
import be.ozdemir.schoolsout.model.User;
import be.ozdemir.schoolsout.utils.TransactionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class UserRepo {

    public Optional<User> getUserByLogin (String login){
        EntityManager em = EntityManagerCreator.createEM();
        User user = em.find(User.class, login);
        if (user != null) {
            return (Optional.of(user));
        }
        return (Optional.empty());
    }

    public Boolean insertUser (User user){
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public User updateUser (User user){
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        if (getUserByLogin(user.getLogin()).isEmpty()) {
            System.out.println(user.getLogin() + " is inserted into the database");
            user = em.merge(user);
            em.getTransaction().commit();
            em.close();
            return user;
        } else {
            System.out.println(user.getLogin() + " is updated");
            user = em.merge(user);
            em.getTransaction().commit();
            em.close();
            return user;
        }
    }

    public Optional<User> deleteUser (User user) throws TransactionException {
        EntityManager em = EntityManagerCreator.createEM();
        em.getTransaction().begin();
        if (getUserByLogin(user.getLogin()) == null){
            throw new TransactionException ("No such user found to be removed");
        } else {
            em.remove(user);
            return Optional.of(user);
        }
    }
}
