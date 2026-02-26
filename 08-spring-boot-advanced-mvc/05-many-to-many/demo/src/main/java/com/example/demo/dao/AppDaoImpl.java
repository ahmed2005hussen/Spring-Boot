package com.example.demo.dao;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AppDaoImpl implements AppDao {

    EntityManager em;

    @Autowired
    public AppDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        em.persist(instructor);
    }

    @Override
    public Instructor getInstructor(int id) {
        return em.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail getInstructorDetail(int id) {
        return em.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {

        Instructor instructor = em.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();

        for(Course course : courses){
            course.setInstructor(null);
        }

        em.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail = em.find(InstructorDetail.class, id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        em.remove(instructorDetail);
    }

    @Override
    public List<Course> getInstructorCourses(int id) {

        TypedQuery query = em.createQuery("from Course where instructor.id= :instId", Course.class);
        query.setParameter("instId", id);

        List<Course> courses = query.getResultList();
        return courses;

    }

    @Override
    public Instructor findInstructorByFetchJoin(int id) {

        TypedQuery query = em.createQuery(
                "select i from Instructor i " +
                "join fetch i.courses " +
                "where i.id = :instID", Instructor.class);

        query.setParameter("instID", id);

        Instructor instructor = (Instructor) query.getSingleResult();
        return instructor;


    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        em.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        em.merge(course);
    }

    @Override
    public Course findCourseById(int id) {

        Course course = em.find(Course.class, id);

        return course;
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course course = em.find(Course.class, id);
        em.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {

        em.persist(course);

    }

    @Override
    public Course findCourseAndReviewById(int id) {

        TypedQuery query = em.createQuery(
                "select i from Course i " +
                        "join fetch i.reviews " +
                        "where i.id = :crsId", Course.class);

        query.setParameter("crsId" , id);

        Course c = (Course) query.getSingleResult();

        return c;
    }

    @Override
    public Course findCourseAndStudentById(int id) {


        TypedQuery query = em.createQuery("select c from Course c join fetch c.students where c.id = :data" , Course.class);
        query.setParameter("data", id);

        Course c = (Course) query.getSingleResult();

        return c;

    }

    @Override
    public Student findStudentAndCourseById(int id) {


        TypedQuery query = em.createQuery("select s from Student s join fetch s.courses where s.id = :data " , Student.class);

        query.setParameter("data", id);

        Student s = (Student) query.getSingleResult();

        return s;

    }

    @Override
    @Transactional
    public void update(Student student) {

        em.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {

        Student s = findStudentAndCourseById(id);

        if(s!= null) {


            List<Course> courses = s.getCourses();

            for(Course c : courses){
                c.getStudents().remove(s);
            }
            em.remove(s);
        }
    }
}
