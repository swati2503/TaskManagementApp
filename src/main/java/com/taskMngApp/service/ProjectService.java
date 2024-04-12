package com.taskMngApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskMngApp.dao.ProjectRepo;
import com.taskMngApp.model.Project;

@Service
public class ProjectService {
	private final ProjectRepo projectRepository;

    @Autowired
    public ProjectService(ProjectRepo projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project project) {
        if (!projectRepository.existsById(id)) {
            return null;
        }
        project.setId(id); // Ensure the project ID is set correctly
        return projectRepository.save(project);
    }


}
