package com.qingyi.SBJM.Dao.Jdbc.Impl;

import com.qingyi.SBJM.Dao.Jdbc.JdbcUserDao;
import com.qingyi.SBJM.Entity.User;
import com.qingyi.SBJM.Enviorment.JdbcComEnviorment;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>用户数据的交互(JDBC方式)</p>
 *
 * @author qingyi xuelongqy@foxmail.com
 * @version V1.0
 * @ClassName: JdbcUserDaoImpl
 * @Package com.qingyi.SBJM.Dao.Jdbc.Impl
 * @Description: 用户数据的交互(JDBC方式)
 * @date 2017/1/13 0:25
 */
@Repository
public class JdbcUserDaoImpl extends JdbcComEnviorment implements JdbcUserDao {
    //通过姓名获取用户信息
    @Override
    public List<User> findByUsername(String username) {
        //生成sql语句
        String sql = null;
        try {
            sql = GET_SQL(new String[] { username },"select * from User where username = '?'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //执行并获取数据
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        //遍历数据并封装
        List<User> users = new ArrayList<>();
        while (rowSet.next()){
            User user = new User();
            user.setId(rowSet.getInt("id"));
            user.setUsername(rowSet.getString("username"));
            user.setPassword(rowSet.getString("password"));
            users.add(user);
        }
        //返回封装的数据
        return users;
    }
}
