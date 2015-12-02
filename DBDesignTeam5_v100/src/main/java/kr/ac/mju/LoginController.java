package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;

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

import kr.ac.mju.exception.InputDataNotValidException;
import kr.ac.mju.exception.InputDataRedundantException;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private JoinService joinService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/LoginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttr) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		User user = service.login(userID, userPassword);
		logger.info("로그인시도"+userID);

		if(user.getName()!=""){
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(60*60);
			return "main";
		}else{
			redirectAttr.addFlashAttribute("errormsg","로그인에 실패하였습니다!");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/LoginController/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		session.removeAttribute("user");
		logger.info("로그아웃");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/LoginController/join.do", method = RequestMethod.POST)
 	public String join(HttpServletRequest request, Model model)
 			throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
 		
 		logger.info("회원가입 요청을 받았습니다.");
 		
 		request.setCharacterEncoding("UTF-8");
 		String userID = request.getParameter("userID");
 		String userPassword = request.getParameter("userPassword");
 		String userPasswordCheck = request.getParameter("userPasswordCheck");
 		String name = request.getParameter("name");
 		String age = request.getParameter("age");
 		String phoneNumber = request.getParameter("phoneNumber");
 		String address = request.getParameter("address");
 		String email = request.getParameter("email");
 		String ssnPrefix = request.getParameter("ssnPrefix");
 		String ssnSuffix = request.getParameter("ssnSuffix");
 		String worksDepartment = request.getParameter("worksDepartment");
 		String position = request.getParameter("position");
 		String hiredDate = request.getParameter("hiredDate");
 		String previousCareer = request.getParameter("previousCareer");
 		String finalEducation = request.getParameter("finalEducation");
 		
 		try {
 			
 			boolean success = joinService.join(userID, userPassword, userPasswordCheck,
 					name, age, phoneNumber, address, email, ssnPrefix, ssnSuffix, worksDepartment, position,
 					hiredDate, previousCareer, finalEducation);
 			
 			if (success == true) {
 				logger.info(name + "님이 성공적으로 회원가입 했습니다.");
 				return "redirect:/";
 			} else {
 				logger.info(name + "님의 회원가입에 실패했습니다.");
 				request.setAttribute("errorMessage", "회원가입에 실패했습니다.");
 				return "/join";
 			}
 		} catch (InputDataNotValidException e) {
 			request.setAttribute("errorMessage", e.getMessage());
 			return "/join";
 		} catch (InputDataRedundantException e) {
 			request.setAttribute("errorMessage", e.getMessage());
 			return "/join";
 		} catch (ParseException e) {
 			request.setAttribute("errorMessage", e.getMessage());
 			return "/join";
 		}
 	}
	
	
	
}
