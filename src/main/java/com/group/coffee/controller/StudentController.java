package com.group.coffee.controller;

import com.group.coffee.model.Student;
import com.group.coffee.service.implementation.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentImpl studentImplService;

    @GetMapping("/index")
    public String homePage(){
        return "index";
    }
    @GetMapping("/SignIn")
    public String SignInPage(){
        return "signIn";
    }

    @GetMapping("/signUp")
    public String createStudent(Model model){
        Student stud = new Student();
        model.addAttribute("student", stud);
        return "signUp";
    }
    @PostMapping("/signUp")
    public String createStudents(@ModelAttribute("student") Student students){
        Student savedStudent = studentImplService.createStudent(students);
        if(savedStudent !=null){
            return "redirect:/signIn";
        }
        return "signUp";
    }
}
