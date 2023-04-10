package com.group.coffee.service;

import com.group.coffee.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent (Student stud);
    Student updateStudent (Student stud);
    void deleteStudent (Student stud);
    List<Student> studentList();
    Student findStudentById (Student stud);
}
