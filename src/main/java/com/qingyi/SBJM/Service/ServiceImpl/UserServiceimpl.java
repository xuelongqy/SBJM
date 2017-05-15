package com.qingyi.SBJM.Service.ServiceImpl;
import com.qingyi.SBJM.Dao.Jdbc.JdbcUserDao;
import com.qingyi.SBJM.Dao.Jpa.JpaUserDao;
import com.qingyi.SBJM.Dao.Mybatis.MybatisUserDao;
import com.qingyi.SBJM.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qingyi.SBJM.Service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务层(处理关于用户的逻辑)
 *
 * @author qingyi xuelongqy@foxmail.com
 * @Title: UserServiceimpl类
 * @Description: 用户服务层
 * @version: V1.0
 * @date 2017 -01-17 21:01:19
 */
@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private JdbcUserDao userDao2;
	@Autowired
	private JpaUserDao userDao;
	@Autowired
	private MybatisUserDao userDao3;

	/**
	 * 验证用户登陆情况
	 * @Title: UserService的验证用户登陆情况方法
	 * @Description: 验证用户登陆情况
	 * @author qingyi xuelongqy@foxmail.com
	 * @date 2016/12/13 14:37
	 * @param user 用户对象
	 * @return 是否成功登陆
	 */
	@Override
	@Transactional
	public boolean isLogin(User user) {
		//获取用户对象
        List<User> users = userDao.findByUsername(user.getUsername());
        if (users == null || users.isEmpty()){
            return false;
        }
		User getUser = users.get(0);
		//判断密码是否一致
		return user.getPassword().equals(getUser.getPassword());
	}

}
