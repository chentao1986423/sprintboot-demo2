package com.example.demo02.controller;

import com.example.demo02.model.Role;
import com.example.demo02.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    // 用户Servic对象
    @Autowired
    private RoleService roleService;

    /**
     * 所有用户信息取得
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAllRole() {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            List<Role> list = this.roleService.listAllRole();
            result.put("status", "ok");
            result.put("list", list);
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息取得
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Object getRoleDetail(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Role role = this.roleService.getRole(id);
            if (role != null) {
                result.put("status", "ok");
                result.put("role", role);
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户不存在");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 创建用户信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createRole(
            @RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = false) String description) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Role role = new Role();
            role.setId(id);
            role.setName(name);
            role.setDescription(description);
            int cnt = this.roleService.createRole(role);
            if (cnt > 0) {
                result.put("status", "ok");
                result.put("role", role);
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户创建失败");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object deleteRole(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int cnt = this.roleService.deleteRole(id);
            if (cnt > 0) {
                result.put("status", "ok");
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户删除失败");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }
}

