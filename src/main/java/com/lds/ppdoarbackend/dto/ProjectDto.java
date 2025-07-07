package com.lds.ppdoarbackend.dto;

import com.lds.ppdoarbackend.model.ProjectImage;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ProjectDto {
    private String id;
    private String title;
    private String description;
    private String location;
    private Date startDate;
    private Date endDate;
    private Date implementationSchedule;
    private Date dateOfAccomplishment;
    private Double budget;
    private Double percentCompletion;
    private String targetParticipant;
    private String fundSource;
    private String divisionId;
    private String status;
    private String officeInCharge;
    private List<ProjectImage> images;
}