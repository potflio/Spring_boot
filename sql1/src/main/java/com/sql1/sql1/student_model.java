package com.sql1.sql1;

import jakarta.persistence.*;

@Entity
public class student_model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Column(name = "Student Email")
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Student Password")
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
