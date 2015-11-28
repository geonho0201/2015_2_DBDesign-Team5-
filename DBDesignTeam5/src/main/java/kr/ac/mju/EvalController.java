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
public class EvalController {
	
	@Autowired
	private EvalService service;
	
	private static final Logger logger = LoggerFactory.getLogger(EvalController.class);
	
	
	@RequestMapping(value = "/EvalController/func.do", method = RequestMethod.GET)
	public String func(HttpServletRequest request, Model model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		
		logger.info("");
		
		return "redirect:/";
	}
	
	
	
}