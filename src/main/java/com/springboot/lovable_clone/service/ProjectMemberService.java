package com.springboot.lovable_clone.service;

import com.springboot.lovable_clone.dto.member.InviteMemberRequest;
import com.springboot.lovable_clone.dto.member.MemberResponse;
import com.springboot.lovable_clone.dto.member.UpdateRoleRequest;
import com.springboot.lovable_clone.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateRoleRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
