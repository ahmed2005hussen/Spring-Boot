package com.example.demo;

import com.example.demo.dao.AppDao;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {

            // createInstructor(appDao);

//           findInstuctorById(appDao);

            //deleteInstructorById(appDao);

//            findInsturctorDetailById(appDao);


//            deleteInsturctorDetailById(appDao);


              createInstructorWithCourse(appDao);

        };

    }

    private void createInstructorWithCourse(AppDao appDao) {
        Instructor instructor = new
                Instructor("Ahmed", "Hussein", "ahmed@gmail.com");

        InstructorDetail instructorDetail = new
                InstructorDetail("Ahmed123@youtube.com", "Football");

        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("Spring Boot");
        Course course2 = new Course("Java");


        instructor.add(course );
        instructor.add(course2);

        System.out.println("Created instructor: " + instructor);

        appDao.save(instructor);

        System.out.println("Done " + instructor );
        System.out.println("Done "  + instructor.getInstructorDetail());
        System.out.println("Done " + instructor.getCourses());

    }

    private void deleteInsturctorDetailById(AppDao appDao) {

        int id = 2;
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

        int id = 2;
        appDao.deleteInstructor(id);
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
