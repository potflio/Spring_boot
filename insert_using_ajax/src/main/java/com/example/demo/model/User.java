package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_mobile",length = 20)
    private long mobile; 

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getmobile() {
        return mobile;
    }

    public void setmobile(long mobile) {
        this.mobile = mobile;
    }

}
