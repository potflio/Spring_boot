package com.example.ajax_api.model;

import jakarta.persistence.*;

@Entity
public class model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // Constructors
    public model() {}

    public model(String name, int age) {
        this.name = name;
        this.age = age;
    }

     // Getters & Setters
     public Long getId() { return id; }
     public void setId(Long id) { this.id = id; }
 
     public String getName() { return name; }
     public void setName(String name) { this.name = name; }
 
     public int getAge() { return age; }
     public void setAge(int age) { this.age = age; }

}
