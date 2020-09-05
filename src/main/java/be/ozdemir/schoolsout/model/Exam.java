package be.ozdemir.schoolsout.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
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

    @OneToOne
    private Exam examGroup;

    @OneToMany
    private List<Exam> subExams;

    @OneToMany(mappedBy = "exam")
    private List<Grade> grades;

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

    public Exam getExamGroup() {
        return examGroup;
    }

    public Exam setExamGroup(Exam examGroup) {
        this.examGroup = examGroup;
        return this;
    }

    public List<Exam> getSubExams() {
        return subExams;
    }

    public Exam setSubExams(List<Exam> subExams) {
        this.subExams = subExams;
        return this;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Exam setGrades(List<Grade> grades) {
        this.grades = grades;
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
