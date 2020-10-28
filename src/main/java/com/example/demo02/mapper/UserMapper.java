package com.example.demo02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.demo02.model.User;

@Mapper
public interface UserMapper {

    /**
     * 查询指定ID的数据
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    public User findOne(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    @Select("select * from user")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "mobile", property = "mobile"),
                    @Result(column = "email", property = "email")
            }
    )
    public List<User> findAll();

    /**
     * 插入数据
     *
     * @param data
     * @return
     */
    @Insert("insert into user values(#{id},#{name},#{mobile},#{email})")
    public int insert(User data);

    /**
     * 删除指定ID的数据
     *
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    public int delete(Long id);

}

