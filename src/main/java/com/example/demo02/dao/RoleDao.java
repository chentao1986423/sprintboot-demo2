package com.example.demo02.dao;

import com.example.demo02.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Long> {

//    /**
//     * 查询指定ID的数据
//     *
//     * @param id
//     * @return
//     */
//    public User findOne(Long id);
//
//    /**
//     * 查询所有数据
//     *
//     * @return
//     */
//    public List<User> findAll();
//
//    /**
//     * 插入数据
//     *
//     * @param data
//     * @return
//     */
//    public int insert(User data);
//
//    /**
//     * 删除指定ID的数据
//     *
//     * @param id
//     * @return
//     */
//    public int delete(Long id);

}

