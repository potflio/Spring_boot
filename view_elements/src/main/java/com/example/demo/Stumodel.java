package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Stumodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_id")
    private Long id;

    @Column(name = "Student_name")
    private String name;

    @Column(name = "Student_gender")
    private String gender;

    @Column(name = "Student_city")
    private String city;
    
    @Column(name = "Student_skills")
    private String skills;

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSkills(){
        return skills;
    }

    public void setSkills(String skills){
        this.skills = skills;
    }

}
