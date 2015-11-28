package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/LoginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttr) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		User user = service.login(userID, userPassword);
		logger.info("�α��νõ�"+userID);

		if(user.getName()!=""){
			session.setAttribute("user", user);
			return "main";
		}else{
			redirectAttr.addFlashAttribute("errormsg","�α��ο� �����Ͽ����ϴ�!");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/LoginController/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		
		logger.info("�α׾ƿ�");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/LoginController/join.do", method = RequestMethod.POST)
	public String join(HttpServletRequest request, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		
		logger.info("ȸ������");
		
		return "join";
	}
	
	
	
}
