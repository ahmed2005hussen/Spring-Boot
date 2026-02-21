package com.example.demo.dao;

import com.example.demo.entity.Instructor;

public interface AppDao {

    void save(Instructor instructor);
    Instructor getInstructor(int id);

    void deleteInstructor(int id);
}
