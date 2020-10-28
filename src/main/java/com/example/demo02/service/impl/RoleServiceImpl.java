package com.example.demo02.service.impl;

import com.example.demo02.dao.RoleDao;
import com.example.demo02.mapper.UserMapper;
import com.example.demo02.model.Role;
import com.example.demo02.model.User;
import com.example.demo02.service.RoleService;
import com.example.demo02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService实现类
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listAllRole() {
        List<Role> list = roleDao.findAll();
        return list;
    }

    @Override
    public Role getRole(Long id) {
        Role role  = roleDao.findById(id).orElse(null);
        return role;
    }

    @Override
    public int createRole(Role role) {
        try{
            roleDao.save(role);
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteRole(Long id) {
        try {
            roleDao.deleteById(id);
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}

