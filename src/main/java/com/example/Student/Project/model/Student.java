package com.example.Student.Project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue
    Long id;
//    private int id;
    private String name;
    private int rollno;
    private String section;

    public Student() {
    }

  public Student(String name, int rollno, String section) {
//
        this.name = name;
        this.rollno = rollno;
        this.section = section;
    }
//    public int getid(){
//        return id;
//    }
//    public void setId(){
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
