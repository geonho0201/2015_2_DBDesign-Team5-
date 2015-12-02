package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvalController {
	
	@Autowired
	private EvalService eService;
	@Autowired
	private ProjectService pService;
	@Autowired
	private Eval eval;
	private Assignment assignment;
	User user;
	
	private static final Logger logger = LoggerFactory.getLogger(EvalController.class);
	
	
	@RequestMapping(value ="/EvalController/evalList.do", method = RequestMethod.GET)
	public ModelAndView evalList(HttpSession session) throws ClassNotFoundException, SQLException
	{
		ModelAndView model = new ModelAndView();
		List<User> develList = eService.getDeveloperList();
		
		model.setViewName("evallist");
		model.addObject("develList", develList);
		logger.info("평가내역");
		
		return model;
	}
	
	@RequestMapping(value ="/EvalController/getevalList.do", method = RequestMethod.POST)
	public ModelAndView getevalList(HttpServletRequest request) throws ClassNotFoundException, SQLException
	{
		ModelAndView model = new ModelAndView();
		String employee_number = request.getParameter("employee_number");
		List<User> develList = eService.getDeveloperList();
		List<Eval> evalList = eService.getEvalList(employee_number);
		
		model.setViewName("evallist");
		model.addObject("develList", develList);
		model.addObject("getEvalList", evalList);
		
		logger.info("평가내역");
		
		return model;
	}
	
	@RequestMapping(value = "/EvalController/eval.do")
	public String evaluate(@RequestParam String employee_number, @RequestParam String project_number, 
					HttpSession session, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {	
		logger.info("");
		
		user= (User)session.getAttribute("user");
		List<Assignment> list = new ArrayList<Assignment>();
		list = pService.loadAssignedMem(project_number.substring(0, 8));
		
		model.addAttribute("myJob",eService.getMyJob(user.getEmployee_number(), project_number.substring(0, 8)));
		model.addAttribute("list", list);
		model.addAttribute("selectedEmp", employee_number);
		
		return "eval";
	}
	
	
	@RequestMapping(value="/EvalController/addEval.do",method = RequestMethod.POST)
	public String addEval(@ModelAttribute Eval eval,Model model) throws ClassNotFoundException, SQLException
	{
		if(!eService.evalPeriod(eval.getProject_number())){
			model.addAttribute("message","<script>alert('평가기간이 아닙니다.');history.go(-1);</script>");
			return "eval";
		}else if(eService.insertEval(eval)){
			model.addAttribute("message","<script>alert('평가가 완료 되었습니다.');history.go(-1);</script>");
			return "main";
		}else{
			model.addAttribute("message", "<script>alert('평가가 수정되었습니다.');history.go(-1);</script>");
			eService.updateEval(eval);
			return "eval";
		}
		
	
	
		
	}
	
}