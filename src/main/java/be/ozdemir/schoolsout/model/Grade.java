package be.ozdemir.schoolsout.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Grade {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Exam exam;

    private BigDecimal gradeValue;

    private String comment;

    private String internalComment;

    private Boolean isAbsent;

    private Boolean isPostponed;

    private LocalDate gradeDate;

    public Integer getId() {
        return id;
    }

    public Grade setId(Integer id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Grade setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Exam getExam() {
        return exam;
    }

    public Grade setExam(Exam exam) {
        this.exam = exam;
        return this;
    }

    public BigDecimal getGradeValue() {
        return gradeValue;
    }

    public Grade setGradeValue(BigDecimal gradeValue) {
        this.gradeValue = gradeValue;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Grade setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getInternalComment() {
        return internalComment;
    }

    public Grade setInternalComment(String internalComment) {
        this.internalComment = internalComment;
        return this;
    }

    public Boolean getAbsent() {
        return isAbsent;
    }

    public Grade setAbsent(Boolean absent) {
        isAbsent = absent;
        return this;
    }

    public Boolean getPostponed() {
        return isPostponed;
    }

    public Grade setPostponed(Boolean postponed) {
        isPostponed = postponed;
        return this;
    }

    public LocalDate getGradeDate() {
        return gradeDate;
    }

    public Grade setGradeDate(LocalDate gradeDate) {
        this.gradeDate = gradeDate;
        return this;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", person=" + person +
                ", exam=" + exam +
                ", gradeValue=" + gradeValue +
                ", comment='" + comment + '\'' +
                ", internalComment='" + internalComment + '\'' +
                ", isAbsent=" + isAbsent +
                ", isPostponed=" + isPostponed +
                ", gradeDate=" + gradeDate +
                '}';
    }
}
