package com.qingyi.SBJM.Enviorment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
public class JdbcComEnviorment {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/**
	 * 保护类型的构造函数(被继承后才能实例化)
	 *
	 * @Title: JdbcComEnviorment的构造函数
	 * @Description: 保护类型的构造函数
	 * @author qingyi xuelongqy@foxmail.com
	 * @date 2017 -01-17 20:42:24
	 */
	protected JdbcComEnviorment() {}

	/**
	 * 此方法帮助拼接字符串，只用传入存储过程的函数名称和需要的值（值填？）再输入要传入的值放入String[]里进行了
	 * 
	 * @param parames
	 * @param SQL
	 * @return 生成的sql语句
	 * @throws Exception
	 */
	public String GET_SQL(String[] parames, String SQL) throws Exception {
		int x = 0;
		// 遍历数组的每个元素
		for (int i = 0; i <= SQL.length() - 1; i++) {
			String getstr = SQL.substring(i, i + 1);
			if (getstr.equals("?")) {
				x++;
			}
		}
		if (parames.length == x) {
			for (int i = 0; i < x; i++) {
				SQL = SQL.replaceFirst("\\?", parames[i]);
			}
		} else {
			throw new Exception("传入的值与设值对应有误!");
		}
		showSql(SQL);
		return SQL;
	}

    /**
     * 显示sql语句(日志输出)
     *
     * @param sql 需要显示的sql语句
     * @Title: showSql方法
     * @Description: 显示sql语句(日志输出)
     * @author qingyi xuelongqy@foxmail.com
     * @date 2017 -01-17 00:54:20
     */
    public void showSql(String sql){
		Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		logger.debug(sql);
	}
}
