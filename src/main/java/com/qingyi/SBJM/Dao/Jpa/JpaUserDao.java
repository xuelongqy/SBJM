package com.qingyi.SBJM.Dao.Jpa;

import com.qingyi.SBJM.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * <p>用户数据的交互(JPA方式)</p>
 *
 * @author qingyi xuelongqy@foxmail.com
 * @version V1.0
 * @InterfaceName: UserDao
 * @Package com.qingyi.SBJM.Dao
 * @Description: 用户数据的交互(JPA方式)
 * @date 2016/12/13 11:36
 */
public interface JpaUserDao extends JpaRepository<User,Integer> {
    //通过姓名查找用户
    public List<User> findByUsername(String username);
}
