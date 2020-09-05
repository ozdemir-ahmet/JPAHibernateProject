package be.ozdemir.schoolsout.repos;

import be.ozdemir.schoolsout.utils.EntityManagerFactoryCreator;
import be.ozdemir.schoolsout.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class UserRepo {
    EntityManagerFactory emf = EntityManagerFactoryCreator.createEMF();
    EntityManager em = emf.createEntityManager();

    public Optional<User> getUserByLogin (String login){
        User user = em.find(User.class, login);
        if (user != null) {
            return (Optional.of(user));
        } else return (Optional.empty());
    }

    public Boolean insertUser (User user){
        em.getTransaction().begin();
        try{
            em.persist(user);
        } catch (RuntimeException re){
            System.out.println(re.getMessage());
            return false;
        }
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public User updateUser (User user){
        em.getTransaction().begin();
        try{
            if(getUserByLogin(user.getLogin()).isEmpty()) {
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
        }catch (RuntimeException re){
            System.out.println(re.getMessage());
            return user;
        }


    }

}
