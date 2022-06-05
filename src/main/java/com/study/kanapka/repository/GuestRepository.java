package com.study.kanapka.repository;

import com.study.kanapka.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository <Guest, Long>{

    Guest findDistinctById(Long id);
}
