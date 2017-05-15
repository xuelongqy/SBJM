package com.qingyi.SBJM.Dao.Jdbc;

import com.qingyi.SBJM.Entity.User;
import java.util.List;

/**
 * <p>用户数据的交互(JDBC方式)</p>
 *
 * @author qingyi xuelongqy@foxmail.com
 * @version V1.0
 * @InterfaceName: JdbcUserDao
 * @Package com.qingyi.SBJM.Dao.Jdbc
 * @Description: 用户数据的交互(JDBC方式)
 * @date 2017/1/13 0:24
 */
public interface JdbcUserDao {
    //通过姓名获取用户信息
    public List<User> findByUsername(String username);
}
