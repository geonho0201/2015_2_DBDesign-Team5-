package kr.ac.mju;

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

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	private Assignment assignment;
	private User user;
	private String comparison;
	private String project_number;
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	
	@RequestMapping(value = "/ProjectController/projectLoad.do", method = RequestMethod.GET)
	public String showProject(HttpSession session, Model model) throws ClassNotFoundException, SQLException{
		
		logger.info("");
		
		user = (User)session.getAttribute("user");
		if(user.getWorks_department().equals("02")){
			comparison = "%";
		}else{
			comparison = user.getEmployee_number();
		}
		List<Project> list = service.loadProject(comparison);
		model.addAttribute("list",list);
		
		return "project";
	}
	
	@RequestMapping(value = "/ProjectController/assign.do", method = RequestMethod.POST)
	public String assignedMember(HttpServletRequest request, Model model) throws ClassNotFoundException, SQLException{
		
		logger.info("");
		
		project_number = request.getParameter("project_number");
		List<Assignment> list = service.loadAssignedMem(project_number.substring(0, 8));
		model.addAttribute("list",list);
		
		return "assign";
	}
	
}