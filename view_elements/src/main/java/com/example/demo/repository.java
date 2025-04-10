package com.example.demo;

import com.example.demo.Stumodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<Stumodel,Long>{
    
}
