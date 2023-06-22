package com.lhind.util;

import com.lhind.model.dto.RoleDto;
import com.lhind.model.dto.UserDetailDto;
import com.lhind.model.dto.UserDto;
import com.lhind.model.entity.Role;
import com.lhind.model.entity.User;
import com.lhind.model.entity.UserDetail;

import java.util.stream.Collectors;


public class DtoConversion {

    public UserDto convertUser(User user) {
        UserDto userDto = new UserDto();

        if (user.getId() != null) {
            userDto.setId(user.getId());
        }

        if (user.getUsername() != null){
            userDto.setUsername(user.getUsername());
        }

        if (user.getRoles() != null) {
            userDto.setRoles(user.getRoles().stream().map(this::convertRole).collect(Collectors.toSet()));
        }

        if (user.getUserDetail() != null) {
            userDto.setUserDetail(this.convertUserDetail(user.getUserDetail()));
        }


        return userDto;
    }


    public UserDetailDto convertUserDetail(UserDetail userDetail) {
        UserDetailDto userDetailDto = new UserDetailDto();
        if (userDetail.getId() != null){
            userDetailDto.setId(userDetail.getId());
        }

        if (userDetail.getFirstName() != null){
            userDetailDto.setFirstName(userDetail.getFirstName());
        }

        if (userDetail.getLastName() != null){
            userDetailDto.setLastName(userDetail.getLastName());
        }

        if (userDetail.getEmail() != null){
            userDetailDto.setEmail(userDetail.getEmail());
        }

        if (userDetail.getPhoneNumber() != null){
            userDetailDto.setPhoneNumber(userDetail.getPhoneNumber());
        }

        if (userDetail.getAddress() != null){
            userDetailDto.setAddress(userDetail.getAddress());
        }

        return userDetailDto;
    }

    public RoleDto convertRole(Role role) {
        RoleDto roleDto = new RoleDto();

        if (role.getId() != null){
            roleDto.setId(role.getId());
        }

        if (role.getName() != null){
            roleDto.setName(role.getName());
        }

        return roleDto;
    }

}
