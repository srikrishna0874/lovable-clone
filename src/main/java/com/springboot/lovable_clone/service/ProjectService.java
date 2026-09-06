package com.springboot.lovable_clone.service;

import com.springboot.lovable_clone.dto.project.ProjectRequest;
import com.springboot.lovable_clone.dto.project.ProjectResponse;
import com.springboot.lovable_clone.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDeleteProject(Long id);
}
