
package com.example.spring;

import com.example.spring.model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<model,Long>{
    
}
