package com.example.demo1;

import java.util.List;

import com.example.demo1.DAO.StudentDAO;
import com.example.demo1.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }


    @Bean
    public CommandLineRunner CommandLineRunner(StudentDAO student) {
        return runner -> {
//          createStudent(student);
//          createMultipleStudent(student);
//            readStudent(student);

//            findAllStudent(student);

//            finadAllWithLastName(student);


//            update(student);

//            Delete(student);

            deleteAllStudent(student);
        };


    }

    private void deleteAllStudent(StudentDAO student) {
        int number = student.deleteAll();
        System.out.println(number);
    }

    private void Delete(StudentDAO student) {
        int index = 2;

        student.delete(index);
        System.out.println("Deleted student with id " + index + " successfully");

    }

    private void update(StudentDAO student) {
        Student s = student.findById(1);
        System.out.println(s);

        s.setLastName("Updated");
        student.update(s);
        s = student.findById(1);
        System.out.println(s);
    }

    private void finadAllWithLastName(StudentDAO student) {

        student.findByLastName("Ahmed").forEach(System.out::println);
    }

    private void findAllStudent(StudentDAO student) {
        List<Student> all = student.findAll();

        for (Student s : all) {
            System.out.println(s);
        }

    }

    private void readStudent(StudentDAO student) {

        // find the student with id = 1

        Student s = student.findById(1);

        System.out.println(s);

    }

    private void createMultipleStudent(StudentDAO student) {

        System.out.println("Creating 3 Students");
        Student s1 = new Student("Hussein", "Ahmed", "hussein@gamil.com");
        Student s2 = new Student("Mohammed", "Ahmed", "Mohammed@gamil.com");
        Student s3 = new Student("Saleh", "Ahmed", "Saleh@gamil.com");

        System.out.println("Saving Students");
        student.save(s1);
        student.save(s2);
        student.save(s3);

        System.out.println("Saving Students: S1: " + s1.getId() + "\nS2: " + s2.getId() + "\nS3: " + s3.getId());


    }

    private void createStudent(StudentDAO student) {

        System.out.println("Creating Student");
        Student s1 = new Student("Ahmed", "hussein", "ahmed@gamil.com");

        System.out.println("Saving Student");
        student.save(s1);

        System.out.println("Saved Student " + s1.getId());

    }


}
