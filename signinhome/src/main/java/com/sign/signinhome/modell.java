package com.sign.signinhome;


import jakarta.persistence.*;

@Entity
@Table(name="login")
public class modell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="signin_id")
    private Long id; 

    @Column(name="Email")
    private String email;


    @Column(name = "password")
    private String psw;


    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }
    public String getpsw(){
        return psw;
    }
    public void setpsw(String psw){
        this.psw=psw;
    }
  
}
