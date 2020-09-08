package be.ozdemir.schoolsout.view;

import be.ozdemir.schoolsout.model.*;
import be.ozdemir.schoolsout.model.Module;
import be.ozdemir.schoolsout.repos.GradeRepo;
import be.ozdemir.schoolsout.repos.PersonRepo;
import be.ozdemir.schoolsout.repos.UserRepo;
import be.ozdemir.schoolsout.utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = EntityManagerCreator.createEM();

        Exam mathMainExam = Exam.builder()
                .description("Math Main Exam")
                .examDate(LocalDate.of(2020,05,13))
                .examGroup(null)
                .name("Math")
                .total(100)
                .weight(100)
                .build();

        Exam algebraExam = Exam.builder()
                .description("Math Sub Exam1")
                .examDate(LocalDate.of(2020,05,13))
                .examGroup(mathMainExam)
                .name("Math Sub 1")
                .subExams(null)
                .total(50)
                .weight(50)
                .build();

        mathMainExam.setSubExams(List.of(algebraExam));

        Grade gradeAlgebraExam = Grade.builder()
                .comment("Math Sub Exam 1 Grade")
                .exam(algebraExam)
                .gradeDate(algebraExam.getExamDate())
                .gradeValue(new BigDecimal(40.0))
                .internalComment("Really good grade. Congrats!")
                .isAbsent(false)
                .isPostponed(false)
                .build();

        Person ahmet = Person.builder()
                .firstName("Ahmet")
                .familyName("Ozdemir")
                .gender(Gender.MALE)
                .build();

        gradeAlgebraExam.setPerson(ahmet);

        User user = User.builder()
                .login("Ahmet")
                .isActive(true)
                .passwordHash("12345")
                .person(ahmet)
                .build();

        Course math = Course.builder()
                .code("M1")
                .description("This is the Math course")
                .imageURL("ozdemir/ahmet/image1.jpg")
                .isActive(true)
                .name("Math")
                .build();

        ahmet.setCourseActive(math);

        Module algebra = Module.builder()
                .course(math)
                .description("Math course algebra module")
                .name("Albegra")
                .build();

        algebraExam.setModule(algebra);

        Module geometry = Module.builder()
                .course(math)
                .description("Math course geometry module")
                .name("Geometry")
                .build();

//        math.setModules(List.of(algebra));
//
//        PersonRepo personRepo = new PersonRepo();
//        personRepo.insertPerson(ahmet);
//
//        UserRepo userRepo = new UserRepo();
//        userRepo.insertUser(user);
//
        GradeRepo gradeRepo = new GradeRepo();
        gradeRepo.insertGrade(gradeAlgebraExam);
    }
}
