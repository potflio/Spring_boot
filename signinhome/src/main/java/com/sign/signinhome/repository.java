package com.sign.signinhome;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sign.signinhome.model;
public interface repository extends JpaRepository<model,Long>{
    boolean existsByemail(String email);
}
