package kr.ac.mju;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	@Autowired
	private EmployeeService eService;
	private User user = new User();;
	private String comparison;
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
	
	@RequestMapping(value = "/ProjectController/assign.do")
	public String assignedMember(@RequestParam String project_number, HttpSession session, Model model) throws ClassNotFoundException, SQLException{
		
		logger.info("");
		user=(User)session.getAttribute("user");
		List<Assignment> list = service.loadAssignedMem(project_number.substring(0, 8));
		model.addAttribute("job",service.getJob(user.getEmployee_number(),project_number.substring(0, 8)));
		model.addAttribute("project_number", project_number); 	//�ο� ������ ���� ���
		model.addAttribute("list",list);
		return "assign";
	}
	//-------------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/ProjectController/createdPro.do")
	public String showCreateProByMe(HttpSession session,Model model) throws ClassNotFoundException, SQLException
	{
		
		logger.info("");
		
		user =(User)session.getAttribute("user");
		List<String> pm = service.getPM(user.getEmployee_number());
		List<Project> list = service.getMyProject(user.getEmployee_number());
		model.addAttribute("list",list);
		model.addAttribute("pm",pm);
		
		return "createdPro";
	}
	
	@RequestMapping(value="/ProjectController/createForm.do")
	public String showCreateProjectForm(HttpSession session,Model model) throws ClassNotFoundException, SQLException
	{
		logger.info("");
		List<User> list = eService.getEmployeeList("08");	//pm����Ʈ
		user = (User)session.getAttribute("user");			//constructor����
		model.addAttribute("developer",list);
		model.addAttribute("project_number", service.getProjectNum());	//������Ʈ �ѹ� �ε�
		model.addAttribute("session", user);
		
		
		return "createPro";
	}
	
	@RequestMapping(value="/ProjectController/insertPro.do")
	public String createProject(@ModelAttribute Project project,@RequestParam String employee_number, Model model) throws ClassNotFoundException, SQLException
	{
		logger.info("");
		
		service.insertProject(project,employee_number);			//+assignment,assign_job ����
		model.addAttribute("message", "<script>alert('�� ������Ʈ�� ���� �Ǿ����ϴ�.');history.go(-3);</script>");
		return "createPro";
	}
	
	@RequestMapping(value="/ProjectController/deletePro.do")
	public String removeProject(@RequestParam String project_number, Model model) throws ClassNotFoundException, SQLException
	{
		logger.info("");
		
		service.deleteProject(project_number);			//+assignment,assign_job ����
		model.addAttribute("message", "<script>alert('������Ʈ�� ���� �Ǿ����ϴ�.');</script>");
		return "redirect:/ProjectController/createdPro.do";
	}
	
	
	
	
	
}