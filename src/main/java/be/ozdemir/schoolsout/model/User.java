package be.ozdemir.schoolsout.model;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Builder
@Entity
@Table
public class User {

    @Id
    private String login;

    private String passwordHash;

    private Boolean isActive;

    @OneToOne
    private Person person;

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public User setPerson(Person person) {
        this.person = person;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", isActive=" + isActive +
                ", person=" + person +
                '}';
    }
}
