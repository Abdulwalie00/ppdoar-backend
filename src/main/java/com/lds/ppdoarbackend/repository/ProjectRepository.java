package com.lds.ppdoarbackend.repository;

import com.lds.ppdoarbackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> findByDivisionCode(String divisionCode);
}