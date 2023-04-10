package com.group.coffee.service.implementation;

import com.group.coffee.model.Student;
import com.group.coffee.repository.StudentRepo;
import com.group.coffee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Override
    public Student createStudent(Student stud) {
        return studentRepo.save(stud);
    }

    @Override
    public Student updateStudent(Student stud) {
        Student students = findStudentById(stud);
        if(students != null){
            students.setStudentId(stud.getStudentId());
            students.setFirstname(stud.getFirstname());
            students.setLastname(stud.getLastname());
            students.setGender(stud.getGender());
            students.setEmail(stud.getEmail());
            students.setPassword(stud.getPassword());

            return studentRepo.save(students);
        }else{
            return createStudent(stud);
        }

    }

    @Override
    public void deleteStudent(Student stud) {
        studentRepo.delete(stud);
    }

    @Override
    public List<Student> studentList() {
        return studentRepo.findAll();
    }

    @Override
    public Student findStudentById(Student stud) {
        return studentRepo.findById(stud.getId()).get();
    }
}
