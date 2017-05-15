package com.qingyi.SBJM.Dao.Mybatis;

import com.qingyi.SBJM.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>用户数据的交互(Mybatis方式)</p>
 *
 * @author qingyi xuelongqy@foxmail.com
 * @version V1.0
 * @ClassName: UserDao
 * @Package com.qingyi.SBJM.Dao.Mybatis
 * @Description: 用户数据的交互(Mybatis方式)
 * @date 2017/1/12 22:57
 */
@Mapper
public interface MybatisUserDao {
    //通过姓名查找用户(Mybatis方式)
    @Select("select * from User where username = #{name}")
    public List<User> findByUsername(@Param("name") String username);
}
