package com.lds.ppdoarbackend.repository;

import com.lds.ppdoarbackend.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, String> {
}