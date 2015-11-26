package kr.ac.mju;

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
	
	@Autowired
	private LoginService service;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/LoginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		User user = service.login(userID, userPassword);
		logger.info("로그인시도"+userID);
		
		model.addAttribute("name", user.getName());
//		model.addAttribute("name", "이름");
		
		return "main";
	}
	
	
}
