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
    private Date dateCreated;
    private Date dateUpdated;
    private Double budget;
    private String fundSource;
    @ManyToOne
    private Division division;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProjectImage> images;
    private String status;
}