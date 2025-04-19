package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class student_model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String studentName;
    public int studentAge;
    public String gender;
    public String programmingLanguages;
    public String city;
    public String file;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge(){
        return studentAge;
    }

    public void setAge(int studentAge){
        this.studentAge = studentAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProgramming(){
        return programmingLanguages;
    }

    public void setProgramming(String programmingLanguages){
        this.programmingLanguages = programmingLanguages;
    }

    public String getFile(){
        return file;
    }

    public void setFile(String file){
        this.file = file;
    }


}
