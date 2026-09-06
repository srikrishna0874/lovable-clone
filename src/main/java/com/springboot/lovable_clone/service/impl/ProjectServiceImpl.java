package com.springboot.lovable_clone.service.impl;

import com.springboot.lovable_clone.dto.project.ProjectRequest;
import com.springboot.lovable_clone.dto.project.ProjectResponse;
import com.springboot.lovable_clone.dto.project.ProjectSummaryResponse;
import com.springboot.lovable_clone.entity.Project;
import com.springboot.lovable_clone.entity.ProjectMember;
import com.springboot.lovable_clone.entity.ProjectMemberId;
import com.springboot.lovable_clone.entity.User;
import com.springboot.lovable_clone.enums.ProjectRole;
import com.springboot.lovable_clone.error.ResourceNotFoundException;
import com.springboot.lovable_clone.mapper.ProjectMapper;
import com.springboot.lovable_clone.repository.ProjectMemberRepository;
import com.springboot.lovable_clone.repository.ProjectRepository;
import com.springboot.lovable_clone.repository.UserRepository;
import com.springboot.lovable_clone.security.AuthUtil;
import com.springboot.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {

        Long userId = authUtil.getCurrentUserId();

        List<Project> allUserProjects = projectRepository.findAllProjectsAccessibleByUser(userId);
        return projectMapper.toProjectSummaryResponseList(allUserProjects);
    }

    @Override
    public ProjectResponse getProjectById(Long id) {

        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        Long userId = authUtil.getCurrentUserId();

        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {

        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(id, userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDeleteProject(Long id) {

        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(id, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }

    public Project getAccessibleProjectById(Long id, Long userId) {

        return projectRepository.findAccessibleProjectById(id, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", id.toString()));
    }


}
