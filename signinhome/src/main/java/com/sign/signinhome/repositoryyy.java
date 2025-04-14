package com.sign.signinhome;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sign.signinhome.modell;

public interface repositoryyy extends JpaRepository<modell, Long> {
    boolean existsByemail(String email);

}
