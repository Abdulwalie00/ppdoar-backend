package com.lds.ppdoarbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Project {
    @Id
    private String id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String location;
    private Date startDate;
    private Date endDate;
    private Date implementationSchedule;
    private Date dateOfAccomplishment;
    private Date dateCreated;
    private Date dateUpdated;
    private Double budget;
    private Double percentCompletion;
    private String targetParticipant;
    private String fundSource;
    private String officeInCharge;

    @ManyToOne
    private Division division;

    @ManyToOne
    private ProjectCategory projectCategory;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectImage> images;
    private String status;
}