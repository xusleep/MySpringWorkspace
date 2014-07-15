package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import test.mybatis.User;
import test.mybatis.UserMapper;

public class UserController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("  request.getCharacterEncoding() : " + request.getCharacterEncoding());
		System.out.println(" response.getCharacterEncoding() : " + response.getCharacterEncoding());
		UserMapper userMapper =(UserMapper)this.getWebApplicationContext().getBean("userMapper");
		String userName = request.getParameter("name");
		String strAge = request.getParameter("age");
		if(userName != null && strAge != null)
		{
			//userName = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			strAge = request.getParameter("age");
			System.out.println("userName : " + userName);
			System.out.println("     age : " + strAge);
			User userA = new User();
			userA.setName(userName);
			try
			{
				userA.setAge(Integer.parseInt(strAge));
				userMapper.insertUser(userA);
			}
			catch(Exception ex)
			{}
		}
		List<User> userList = userMapper.queryAll(100);
		return new ModelAndView("userlist", "users", userList);
	}
	
}
