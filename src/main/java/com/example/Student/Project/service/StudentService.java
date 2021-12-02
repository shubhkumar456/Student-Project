package com.example.Student.Project.service;

import com.example.Student.Project.model.Student;
import com.example.Student.Project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.swing.SwingUtilities2;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void addstd(Student student){
        repository.save(student);
    }

    public List<Student> getstd(){
        return repository.findAll();
    }

    public Student getstdbyid(Long id){
        Optional<Student> student=repository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }


    public void delete(Long id){
        repository.deleteById(id);
    }

}
