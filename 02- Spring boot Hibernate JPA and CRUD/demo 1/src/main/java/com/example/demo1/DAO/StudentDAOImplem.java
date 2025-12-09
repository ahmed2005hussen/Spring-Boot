package com.example.demo1.DAO;

import com.example.demo1.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.tool.schema.internal.StandardUserDefinedTypeExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImplem implements StudentDAO {

    private EntityManager entityManager;


    @Override
    @Transactional
    public int deleteAll() {
        int numberDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return numberDeleted;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = findById(id);

        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Autowired
    public StudentDAOImplem(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName =:thedata", Student.class);
        query.setParameter("thedata" , lastName);
        return query.getResultList();


    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // using HQL
//        TypedQuery<Student> query = entityManager.createQuery("from Student" , Student.class);

        // using strict JPQL

//        TypedQuery<Student> query = entityManager.createQuery("select s from Student s" ,  Student.class);

        // using order by desc

//        TypedQuery<Student> query = entityManager.createQuery("from Student order by id desc", Student.class);

        // using order by asc the default

        TypedQuery<Student> query = entityManager.createQuery("from Student order by id asc", Student.class);

        return query.getResultList();
    }
}
