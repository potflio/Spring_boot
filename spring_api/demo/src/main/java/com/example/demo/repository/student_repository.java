package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;

public interface student_repository  extends JpaRepository<student_model,Long>{
    
}
