package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AssignController {
	@Autowired
	private EmployeeService eService;
	@Autowired
	private Assignment assignment;
	@Autowired
	private AssignService service;
	@Autowired
	private ProjectService pService;
	User user;
	
	private static final Logger logger = LoggerFactory.getLogger(EvalController.class);
	
	
	@RequestMapping(value = "/AssignController/createForm.do")
	public String createForm(@RequestParam String project_number, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		logger.info("");
		List<User> develList = eService.getEmployeeList("08");
		List<User> designList = eService.getEmployeeList("05");
		List<Assignment> assignList = pService.loadAssignedMem(project_number.substring(0,8));
		model.addAttribute("develList",develList);
		model.addAttribute("designList",designList);
		model.addAttribute("project_number",project_number);
		model.addAttribute("assign",assignList);
		for(Assignment a: assignList)
			System.out.println(a.getEmployee_number());
		
		return "makePro";
	}
	
	@RequestMapping(value = "/AssignController/insertAssign.do")
	public String assignEmp(@ModelAttribute Assignment assignment, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		logger.info("");
		assignment.setProject_number(assignment.getProject_number().substring(0, 8));
		service.insertAssign(assignment);
		model.addAttribute("message","<script>alert('직원이 투입 되었습니다.');</script>");
		return "main";
	}
	
	@RequestMapping(value = "/AssignController/deleteAssign.do")
	public String abortEmp(@RequestParam String employee_number,@RequestParam String project_number, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		logger.info("");
		employee_number=employee_number.substring(0, 8);
		project_number=project_number.substring(0, 8);
		service.deleteAssign(employee_number,project_number);
		model.addAttribute("message","<script>alert('직원이 투출 되었습니다.');</script>");
		return "main";
	}
	
}