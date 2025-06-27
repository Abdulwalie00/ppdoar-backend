package com.lds.ppdoarbackend.config;

import com.lds.ppdoarbackend.model.Division;
import com.lds.ppdoarbackend.model.Project;
import com.lds.ppdoarbackend.model.User;
import com.lds.ppdoarbackend.repository.DivisionRepository;
import com.lds.ppdoarbackend.repository.ProjectRepository;
import com.lds.ppdoarbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create a default admin user if one doesn't exist
        if (userRepository.findByUsername("admin").isEmpty()) {
            User adminUser = new User();
            adminUser.setFirstName("Admin");
            adminUser.setLastName("User");
            adminUser.setEmail("admin@example.com");
            adminUser.setUsername("admin");
            adminUser.setPasswordHash(passwordEncoder.encode("password"));
            adminUser.setRole("ROLE_ADMIN");
            adminUser.setCreatedAt(new Date());
            adminUser.setUpdatedAt(new Date());

            userRepository.save(adminUser);
            System.out.println("Created admin user");
        }

        // Create a sample project if none exist
        if (projectRepository.count() == 0) {
            // A project needs a division, so let's create one first
            Division division = new Division();
            division.setId(UUID.randomUUID().toString());
            division.setName("General Division");
            division.setCode("GEN");
            division.setDateCreated(new Date());
            division.setDateUpdated(new Date());
            divisionRepository.save(division);
            System.out.println("Created sample division");


            Project sampleProject = new Project();
            sampleProject.setId(UUID.randomUUID().toString());
            sampleProject.setTitle("Sample Project");
            sampleProject.setDescription("This is a sample project created by the DataLoader.");
            sampleProject.setLocation("City Hall");
            sampleProject.setStartDate(new Date());
            sampleProject.setBudget(50000.00);
            sampleProject.setFundSource("General Fund");
            sampleProject.setStatus("Ongoing");
            sampleProject.setDivision(division); // Link the project to the division
            sampleProject.setDateCreated(new Date());
            sampleProject.setDateUpdated(new Date());

            projectRepository.save(sampleProject);
            System.out.println("Created sample project");
        }
    }
}