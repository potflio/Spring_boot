package com.sql1.sql1;

import com.sql1.sql1.student_model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface student_rep extends JpaRepository<student_model, Long> {
}
