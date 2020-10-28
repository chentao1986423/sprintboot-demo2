package com.example.demo02.service;


import com.example.demo02.model.Role;

import java.util.List;

/**
 * RoleService
 */
public interface RoleService {

    List<Role> listAllRole();

    Role getRole(Long id);

    int createRole(Role user);

    int deleteRole(Long id);

}

