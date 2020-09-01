package be.ozdemir.schoolsout.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Exam {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    private String description;

    private LocalDate examDate;

    private Integer weight;

    private Integer total;

    @ManyToOne
    private Module module;

    public Long getId() {
        return id;
    }

    public Exam setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Exam setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Exam setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public Exam setExamDate(LocalDate examDate) {
        this.examDate = examDate;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Exam setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public Exam setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Module getModule() {
        return module;
    }

    public Exam setModule(Module module) {
        this.module = module;
        return this;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", examDate=" + examDate +
                ", weight=" + weight +
                ", total=" + total +
                ", module=" + module +
                '}';
    }
}
