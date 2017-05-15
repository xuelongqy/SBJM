package com.qingyi.SBJM.Controller;

import javax.servlet.http.HttpServletRequest;

import com.qingyi.SBJM.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qingyi.SBJM.Service.ServiceManager;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class LoginController {

	@Autowired
	private ServiceManager serviceManager;
	@Autowired
	HttpServletRequest request;
	//获取自定义参数
	@Value("${myname}")
	private String myName;

	@RequestMapping(value = {"/","index","Login_Page"})
	public ModelAndView index(){
		return new ModelAndView("login");
	}

	/**
	 * 用户登陆的Controller
	 * @Title: LoginController的用户登陆的Controller方法
	 * @Description: 登陆的Controller
	 * @author qingyi xuelongqy@foxmail.com
	 * @date 2016/12/13 22:32
	 * @param user 接收前端提交数据
	 * @return 返回对应视图
	 */
	@RequestMapping("/Login")
	public ModelAndView login(User user) {

		//验证登陆
		if(serviceManager.getUserService().isLogin(user)){
			request.setAttribute("Loginstatus",myName+"登陆成功!");
		}else{
			request.setAttribute("Loginstatus",myName+"登陆失败!");
		}
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	/**
	 * json测试数据
	 * @Title: LoginController的json测试数据方法
	 * @Description: 测试json数据
	 * @author qingyi xuelongqy@foxmail.com
	 * @date 2016/12/13 22:33
	 * @return 需要处理的为json的对象
	 */
	@RequestMapping("/JsonInfo")
	public @ResponseBody Object jsonUser() {
		HashMap<String,String> map = new HashMap<>();
		map.put("name","SpringBoot");
		map.put("author","qingyi");
		return map;
	}
	
}
