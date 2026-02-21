package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor getInstructor(int id);

    InstructorDetail getInstructorDetail(int id);

    void deleteInstructor(int id);

    void deleteInstructorDetail(int id);

}
