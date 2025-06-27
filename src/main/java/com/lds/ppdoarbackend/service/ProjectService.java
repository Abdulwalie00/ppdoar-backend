package com.lds.ppdoarbackend.service;

import com.lds.ppdoarbackend.dto.ProjectDto;
import com.lds.ppdoarbackend.model.Project;
import com.lds.ppdoarbackend.repository.DivisionRepository;
import com.lds.ppdoarbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DivisionRepository divisionRepository;

    public List<Project> getAllProjects(String divisionCode) {
        if (divisionCode != null) {
            return projectRepository.findByDivisionCode(divisionCode);
        }
        return projectRepository.findAll();
    }

    public Project getProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setLocation(projectDto.getLocation());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setBudget(projectDto.getBudget());
        project.setFundSource(projectDto.getFundSource());
        project.setDivision(divisionRepository.findById(projectDto.getDivisionId()).orElse(null));
        project.setStatus(projectDto.getStatus());
        project.setImages(projectDto.getImages());
        project.setDateCreated(new Date());
        project.setDateUpdated(new Date());

        return projectRepository.save(project);
    }

    public Project updateProject(String id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setLocation(projectDto.getLocation());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setBudget(projectDto.getBudget());
        project.setFundSource(projectDto.getFundSource());
        project.setDivision(divisionRepository.findById(projectDto.getDivisionId()).orElse(null));
        project.setStatus(projectDto.getStatus());
        project.setImages(projectDto.getImages());
        project.setDateUpdated(new Date());
        return projectRepository.save(project);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}