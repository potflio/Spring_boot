package com.example.ajax_api.repository;

import com.example.ajax_api.model.model;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface repository extends JpaRepository<model,Long>{
    List<model>findByAge(int age);
}
