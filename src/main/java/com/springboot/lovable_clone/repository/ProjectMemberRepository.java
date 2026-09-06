package com.springboot.lovable_clone.repository;

import com.springboot.lovable_clone.entity.ProjectMember;
import com.springboot.lovable_clone.entity.ProjectMemberId;
import com.springboot.lovable_clone.enums.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

    @Query("""
            SELECT pm.projectRole FROM ProjectMember pm
            WHERE pm.id.projectId = :projectId
                AND pm.id.userId = :userId
            """
    )
    Optional<ProjectRole> findRoleByProjectIdAndUserId(Long projectId, Long userId);
}
