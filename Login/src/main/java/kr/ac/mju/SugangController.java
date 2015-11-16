package kr.ac.mju;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SugangController {
private static final Logger logger = LoggerFactory.getLogger(KangjwaController.class);
	
	@Autowired
	SugangService service;
	
	@RequestMapping(value = "/SugangController/sugang", method = RequestMethod.GET)
	public String sugang(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{
		
		model.put("result", service.getList());
		
		return "suganglist";
	}
	
	
	@RequestMapping(value = "/SugangController/sugangSincheong.do", method = RequestMethod.POST)
	public String sugangSincheong(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("utf-8");
		
		String KID = request.getParameter("KID");
		String SID = request.getParameter("SID");
		
		service.sincheong(SID,KID);
		
		
		return "sugang";
	}	
		
	@RequestMapping(value = "/SugangController/mySugang.do", method = RequestMethod.POST)
	public String mysugang(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("SugangID");
		
		model.put("result", service.mysugang(ID));
		
		return "mysugang";
	}
	
	@RequestMapping(value = "/SugangController/sugangClose", method = RequestMethod.GET)
	public String sugangClose(HttpServletRequest request) throws UnsupportedEncodingException{

		System.out.println("닫기");
		return "sugang";
	}
}
