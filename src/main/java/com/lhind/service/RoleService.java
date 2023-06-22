package com.lhind.service;

import com.lhind.model.dto.RoleDto;

import java.util.List;

public interface RoleService {

    public RoleDto save(RoleDto roleDto);

    public List<RoleDto> findAll();

    public RoleDto findById(Integer id);

}
