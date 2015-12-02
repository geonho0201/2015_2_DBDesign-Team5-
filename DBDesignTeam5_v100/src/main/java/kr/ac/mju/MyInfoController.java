package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyInfoController {
	
	@Autowired
	private User user;
	@Autowired
	private MyInfoService myInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@RequestMapping(value ="/MyInfoController/myInfo.do", method = RequestMethod.GET)
	public ModelAndView showInfo(HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		user = (User) session.getAttribute("user");		
		model.setViewName("information");
		model.addObject("user",user);
		
		logger.info("내정보"+user.getId());
		
		return model;
	}
	
	@RequestMapping(value ="/MyInfoController/modify.do", method = RequestMethod.POST)
	public ModelAndView modifyInfo(HttpSession session)
	{
		String[] email;
		ModelAndView model = new ModelAndView();
		user = (User) session.getAttribute("user");
		email=user.getEmail().split("@");
		user.setEmail(email[0]);
		model.setViewName("modify");
		model.addObject("user",user);
		
		logger.info("내정보"+user.getId());
		
		return model;
	}
	
	@RequestMapping(value ="/MyInfoController/updateData.do", method = RequestMethod.POST)
	public String updateInfo(HttpServletRequest request,HttpSession session) throws ClassNotFoundException, SQLException, UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String SSN = request.getParameter("SSN1").concat(request.getParameter("SSN2"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone_number");
		String address = request.getParameter("address");
		String position = request.getParameter("position");
		String works_department = request.getParameter("works_department");
		String email;
		if(request.getParameter("email_support").equals("0")){
			email = request.getParameter("email1")+"@"+request.getParameter("email2");
		}else{
			email = request.getParameter("email1")+"@"+request.getParameter("email_support");
		}
		user = myInfoService.modifyInfo(user,password, name,SSN, age, phone, address, position, works_department,email);
		session.removeAttribute("user");
		session.setAttribute("user", user);
		
		return "information";
		
	}

}
