package kr.ac.mju;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{//hash table�삎�깭, key�� value
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");

		User user = service.login(userID, userPassword);
		
		logger.info("userID : "+userID);
		
		
		if(user.equals(null)){
			return "redirect:/";
		}else{
			model.addAttribute("userName", user.getName());
			return "main";
		}
	}
	
//	@RequestMapping(value = "/loginController/join.do", method = RequestMethod.POST)
//	public String join(HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{
//		request.setCharacterEncoding("utf-8");
//		String userID = request.getParameter("userID");
//		String userPW = request.getParameter("userPW");
//		String userName = request.getParameter("userName");
//		String userType = request.getParameter("userType");
//		
//		service.join(userID, userPW, userName, userType);
//		
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest request){
//		request.getSession().removeAttribute("userSession");
//		return "redirect:/";
//	}
//	
}
