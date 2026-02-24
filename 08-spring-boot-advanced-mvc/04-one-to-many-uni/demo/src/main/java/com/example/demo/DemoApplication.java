package com.example.demo;

import com.example.demo.dao.AppDao;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {

//            createCourseAndReviews(appDao);

//            findCourseAndReviews(appDao);


            deleteCourseById(appDao);

        };

    }

    private void findCourseAndReviews(AppDao appDao) {

        int id = 10 ;

        Course c = appDao.findCourseAndReviewById(id);

        System.out.println(c);
        System.out.println(c.getReviews());

        System.out.println("Done");



    }

    private void createCourseAndReviews(AppDao appDao) {

        Course course = new Course("Spring boot");

        course.addReview(new Review("Good"));
        course.addReview(new Review("Bad"));
        course.addReview(new Review("cool"));

        appDao.save(course);


        System.out.println("done");


    }

    private void deleteCourseById(AppDao appDao) {

        int id = 10;

        appDao.deleteCourseById(id);

        System.out.println("Done");

    }

    private void updateCourse(AppDao appDao) {

        int id = 10;
        Course course = appDao.findCourseById(id);

        course.setTitle("IntroToSpringBoot");

        appDao.updateCourse(course);
        System.out.println("DONE");
    }

    private void updateInstructor(AppDao appDao) {
        Instructor instructor = appDao.findInstructorByFetchJoin(1);

        instructor.setEmail("aaaaaaaaaaaaahmed@gmail.com");
        appDao.updateInstructor(instructor);
        System.out.println("DONE");
    }

    private void findInsturctorWithFetchJoin(AppDao appDao) {

        int id = 1;

        Instructor instructor = appDao.findInstructorByFetchJoin(id);

        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());
        System.out.println(instructor.getCourses());

    }


    private void findInsturctorWithCourses(AppDao appDao) {
        int id = 1;
        Instructor instructor = appDao.getInstructor(id);
        System.out.println(instructor);

        List<Course> courses = appDao.getInstructorCourses(id);
        instructor.setCourses(courses);


        System.out.println(instructor.getCourses());
        System.out.println("done");
    }

    private void createInstructorWithCourse(AppDao appDao) {
        Instructor instructor = new
                Instructor("Ahmed", "Hussein", "ahmed@gmail.com");

        InstructorDetail instructorDetail = new
                InstructorDetail("Ahmed123@youtube.com", "Football");

        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("Spring Boot");
        Course course2 = new Course("Java");


        instructor.add(course);
        instructor.add(course2);

        System.out.println("Created instructor: " + instructor);

        appDao.save(instructor);

        System.out.println("Done " + instructor);
        System.out.println("Done " + instructor.getInstructorDetail());
        System.out.println("Done " + instructor.getCourses());

    }

    private void deleteInsturctorDetailById(AppDao appDao) {

        int id = 1;
        appDao.deleteInstructorDetail(id);
        System.out.println("Done");

    }

    private void findInsturctorDetailById(AppDao appDao) {

        int id = 1;
        InstructorDetail instructorDetail = appDao.getInstructorDetail(id);
        System.out.println(instructorDetail);
        System.out.println();
        System.out.println(instructorDetail.getInstructor());

    }

    private void deleteInstructorById(AppDao appDao) {

        int id = 1;
        appDao.deleteInstructor(id);
        System.out.println("Done");
    }


    private void findInstuctorById(AppDao appDao) {

        int id = 1;
        Instructor instructor = appDao.getInstructor(id);
        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());


    }

    private void createInstructor(AppDao appDao) {

        Instructor instructor = new Instructor("Ahmed", "Hussein", "ahmed@gmail.com");


        InstructorDetail instructorDetail = new InstructorDetail("Ahmed123@youtube.com", "Football");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Created instructor: " + instructor);

        appDao.save(instructor);

        System.out.println("Done " + instructor + instructorDetail);

        instructor = new Instructor("hello", "world", "helloWorld@gmail.com");


        instructorDetail = new InstructorDetail("Ahmed123@youtube.com", "basketball");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Created instructor: " + instructor);

        appDao.save(instructor);

        System.out.println("Done " + instructor + instructorDetail);

    }


}
