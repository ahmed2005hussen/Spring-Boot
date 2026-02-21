package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return em.find(Instructor.class,id);
    }

    @Override
    public InstructorDetail getInstructorDetail(int id) {

        return em.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {

        Instructor instructor = em.find(Instructor.class,id);
        em.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail = em.find(InstructorDetail.class,id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        em.remove(instructorDetail);
    }


}
