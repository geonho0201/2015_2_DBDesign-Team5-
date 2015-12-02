package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(value ="/EmployeeController/employee.do", method = RequestMethod.GET)
	public ModelAndView employee(HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("employee");
		
		logger.info("직원검색메뉴로");
		
		return model;
	}
	
	@RequestMapping(value = "/EmployeeController/employeeRetrieve.do", method = RequestMethod.POST)
	public String employeeRetrieve(HttpServletRequest request, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		
		logger.info("직원검색");
		
		String option = request.getParameter("retrieveOption");
		List<User> userList = service.getEmployeeList(option);
		model.addAttribute("userList", userList);
		
		return "employee";
	}
	
	@RequestMapping(value = "/EmployeeController/employeeSkillset.do", method = RequestMethod.POST)
	public String employeeSkillset(HttpServletRequest request, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		
		logger.info("직원보유기술검색");
		
		
		
		return "employee";
	}
	
}