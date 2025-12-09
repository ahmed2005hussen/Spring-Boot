package com.example.demo1.DAO;

import com.example.demo1.entities.Student;

import java.util.List;

// CRUD
public interface StudentDAO {
    void save(Student student); // Create
    Student findById(Integer id); // Read
    List<Student> findAll();// Read
    List<Student> findByLastName(String name);// Read
    void update(Student student); // Update
    void delete(Integer id); // Delete
    int deleteAll();
}
