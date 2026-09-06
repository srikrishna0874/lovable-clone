package com.springboot.lovable_clone.mapper;

import com.springboot.lovable_clone.dto.member.MemberResponse;
import com.springboot.lovable_clone.entity.ProjectMember;
import com.springboot.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User user);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    MemberResponse toProjectMemberResponseFromProjectMember(ProjectMember projectMember);
}
