package be.ozdemir.schoolsout.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    private String description;

    private String code;

    private String imageURL;

    private Boolean isActive;

    @OneToMany(mappedBy = "course")
    private List<Module> modules;

    @OneToMany(mappedBy ="courseActive" )
    private List<Person> currentStudents;

    @ManyToMany(mappedBy = "courseHistory")
    private List<Person> pastStudents;

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Course setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Course setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Course setModules(List<Module> modules) {
        this.modules = modules;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public List<Person> getCurrentStudents() {
        return currentStudents;
    }

    public Course setCurrentStudents(List<Person> currentStudents) {
        this.currentStudents = currentStudents;
        return this;
    }

    public List<Person> getPastStudents() {
        return pastStudents;
    }

    public Course setPastStudents(List<Person> pastStudents) {
        this.pastStudents = pastStudents;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", isActive=" + isActive +
                ", modules=" + modules +
                '}';
    }
}
