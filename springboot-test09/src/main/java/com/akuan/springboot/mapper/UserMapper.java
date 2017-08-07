package com.akuan.springboot.mapper;

import com.akuan.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: UserMapper
 * @Description: UserMapper
 * @author: zhaozhenkuan
 * @date: 2017-07-31 下午3:06
 * @version: V1.0
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{name,jdbcType=VARCHAR}")
    User findByName(@Param("name") String name);

    @Insert("insert into user (name,age) values(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
