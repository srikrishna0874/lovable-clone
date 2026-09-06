package com.springboot.lovable_clone.service;

import com.springboot.lovable_clone.dto.member.InviteMemberRequest;
import com.springboot.lovable_clone.dto.member.MemberResponse;
import com.springboot.lovable_clone.dto.member.UpdateRoleRequest;
import com.springboot.lovable_clone.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
