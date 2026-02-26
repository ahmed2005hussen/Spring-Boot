package com.example.demo.dao;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);

    Instructor getInstructor(int id);

    InstructorDetail getInstructorDetail(int id);

    void deleteInstructor(int id);

    void deleteInstructorDetail(int id);

    List<Course> getInstructorCourses(int id);

    Instructor findInstructorByFetchJoin(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewById(int id);

    Course findCourseAndStudentById(int id);

    Student findStudentAndCourseById(int id);

    void update(Student student);

    void deleteStudent(int id);

}
