package com.example.demo02.service.impl;

import com.example.demo02.Demo02Application;
import com.example.demo02.model.Role;
import com.example.demo02.service.RoleService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo02Application.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;

    @Test
    void test1() {
        Role role=new Role(11L, "role11", "role11role11");
        roleService.createRole(role);
    }

    @Test
    void test2() {
        List<Role> roleList = roleService.listAllRole();
        for(Role role : roleList) {
            System.out.println(role);
        }
    }

    @Test
    void test3() {
        Role role = roleService.getRole(11L);
        System.out.println(role);
    }

    @Test
    void test4() {
        roleService.deleteRole(11L);
    }
}