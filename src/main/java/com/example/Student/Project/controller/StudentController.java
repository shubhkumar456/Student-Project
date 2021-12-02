package com.example.Student.Project.controller;

import com.example.Student.Project.model.Student;
import com.example.Student.Project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String homepage(Model model){
        List<Student> studentlist= service.getstd();
        model.addAttribute("studentlist",studentlist);
        return "index";
    }

    @GetMapping("/addstd")
    public String addstd(){
        return "add_student";
    }

    @PostMapping("/register")
    public String studentreg(@ModelAttribute Student student, HttpSession session){
        System.out.println(student);
        service.addstd(student);
        session.setAttribute("msg","data added successfully");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,Model model){
        Student student= service.getstdbyid(id);
        model.addAttribute("class",student);
        return "update";

    }

    @GetMapping("/delete/{id}")
    public String deletestd(@PathVariable Long id, HttpSession session){
        service.delete(id);
        session.setAttribute("msg","deleted successfully");
        return "redirect:/";
    }
}
