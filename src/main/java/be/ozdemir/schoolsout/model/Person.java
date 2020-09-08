package be.ozdemir.schoolsout.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String familyName;

    @Enumerated
    private Gender gender;

    @ManyToOne
    private Course courseActive;

    @OneToMany
    private List<Course> courseHistory;

    @OneToMany(mappedBy = "person")
    private List<Grade> grades;

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Person setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Course getCourseActive() {
        return courseActive;
    }

    public Person setCourseActive(Course course) {
        this.courseActive = course;
        return this;
    }

    public List<Course> getCourseHistory() {
        return courseHistory;
    }

    public Person setCourseHistory(List<Course> courseHistory) {
        this.courseHistory = courseHistory;
        return this;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Person setGrades(List<Grade> grades) {
        this.grades = grades;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", gender=" + gender +
                ", course=" + courseActive +
                '}';
    }
}
