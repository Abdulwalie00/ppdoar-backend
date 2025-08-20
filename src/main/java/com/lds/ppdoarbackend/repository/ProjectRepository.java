package com.lds.ppdoarbackend.repository;

import com.lds.ppdoarbackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

    /**
     * Finds projects based on a dynamic combination of division code, status, and year.
     * The query dynamically builds the WHERE clause based on which parameters are provided.
     * @param divisionCode Optional division code to filter by.
     * @param status Optional status to filter by.
     * @param year Optional year (from the startDate) to filter by.
     * @return A list of projects matching the criteria.
     */
    @Query("SELECT p FROM Project p WHERE " +
            "(:divisionCode IS NULL OR p.division.code = :divisionCode) AND " +
            "(:status IS NULL OR p.status = :status) AND " +
            "(:year IS NULL OR YEAR(p.startDate) = :year)")
    List<Project> findByFilters(
            @Param("divisionCode") String divisionCode,
            @Param("status") String status,
            @Param("year") Integer year);
}