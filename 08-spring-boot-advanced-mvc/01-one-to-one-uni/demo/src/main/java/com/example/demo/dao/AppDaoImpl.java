package com.example.demo.dao;

import com.example.demo.entity.Instructor;
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
    @Transactional
    public void deleteInstructor(int id) {

        Instructor instructor = em.find(Instructor.class,id);
        em.remove(instructor);
    }


}
