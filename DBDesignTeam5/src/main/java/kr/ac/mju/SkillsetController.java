package kr.ac.mju;

import java.sql.SQLException;
import java.util.List;

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
public class SkillsetController {
	
	@Autowired
	private SkillsetService service;
	
	private static final Logger logger = LoggerFactory.getLogger(SkillsetController.class);
	
	@RequestMapping(value ="/SkillsetController/of_skillset.do", method = RequestMethod.GET)
	public ModelAndView of_skillset(HttpSession session) throws ClassNotFoundException, SQLException
	{
		User user;
		user = (User)session.getAttribute("user");
		List<Skillset> of_skillset = service.getOfskillsetList(user.getEmployee_number());
		List<Skillset> skillsetlist = service.getSkillsetList();
		ModelAndView model = new ModelAndView();
		model.setViewName("of_skillset");
		model.addObject("of_skillset", of_skillset);
		model.addObject("skillsetlist", skillsetlist);
		
		logger.info("내기술목록");
		
		return model;
	}
	
	@RequestMapping(value ="/SkillsetController/new_of_skillset.do", method = RequestMethod.POST)
	public String new_of_skillset(HttpServletRequest request, HttpSession session) throws ClassNotFoundException, SQLException
	{
		String skillset_number = request.getParameter("of_skillset_number");
		String skillset_name;
		if(skillset_number.equals("0000")){
			skillset_name = request.getParameter("new_of_skillset_name");
		}else{
			skillset_name = request.getParameter("of_skillset_name");
		}
		String skillset_level = request.getParameter("of_skillset_level");
		User user;
		user = (User)session.getAttribute("user");
		String employee_number = user.getEmployee_number();
		service.newSkillset(employee_number, skillset_number, skillset_name, skillset_level);
		
		logger.info("내기술추가등록");
		
		return "redirect:/SkillsetController/of_skillset.do";
	}
	
	@RequestMapping(value ="/SkillsetController/delete_of_skillset.do", method = RequestMethod.POST)
	public String delete_of_skillset(HttpServletRequest request, HttpSession session) throws ClassNotFoundException, SQLException
	{
		User user;
		user = (User)session.getAttribute("user");
		String employee_number = user.getEmployee_number();
		String skill_number = request.getParameter("of_skillset");
		
		service.deleteSkillset(employee_number, skill_number);
		
		logger.info("내기술삭제");
		
		return "redirect:/SkillsetController/of_skillset.do";
	}
	
	@RequestMapping(value ="/SkillsetController/skillset_list.do", method = RequestMethod.GET)
	public ModelAndView skillset_list(HttpSession session) throws ClassNotFoundException, SQLException
	{
		List<Skillset> skillsetlist = service.getSkillsetList();
		ModelAndView model = new ModelAndView();
		model.setViewName("skillset_retrieve");
		model.addObject("skillsetlist", skillsetlist);
		
		logger.info("기술검색메뉴로");
		
		return model;
	}
	
	@RequestMapping(value ="/SkillsetController/skillset_userlist.do", method = RequestMethod.POST)
	public ModelAndView skillset_userlist(HttpServletRequest request) throws ClassNotFoundException, SQLException
	{
		String skill_number = request.getParameter("skill_number");
		int skillset_level = Integer.parseInt(request.getParameter("skillset_level"));
		String more_or_under = request.getParameter("more_or_under");
		
		List<User> skillset_userlist = service.getSkillsetUserList(skill_number, skillset_level, more_or_under);
		List<Skillset> skillsetlist = service.getSkillsetList();
		ModelAndView model = new ModelAndView();
		model.setViewName("skillset_retrieve");
		model.addObject("skillsetlist", skillsetlist);
		model.addObject("skillset_userlist", skillset_userlist);
		
		logger.info("기술직원리스트");
		
		return model;
	}
	
	@RequestMapping(value ="/SkillsetController/get_of_skillset.do", method = RequestMethod.POST)
	public ModelAndView get_of_skillset(HttpServletRequest request) throws ClassNotFoundException, SQLException
	{
		String employee_number = request.getParameter("employee_number");
		String works_department = request.getParameter("works_department");
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		User user = new User();
		user.setEmployee_number(employee_number);
		user.setWorks_department(works_department);
		user.setName(name);
		user.setPosition(position);
		
		List<Skillset> skillsetlist = service.getOfskillsetList(employee_number);
		ModelAndView model = new ModelAndView();
		model.setViewName("get_of_skillset");
		model.addObject("skillsetlist", skillsetlist);
		model.addObject("user", user);
		
		logger.info("해당직원보유기술");
		
		return model;
	}
	
	
	
}