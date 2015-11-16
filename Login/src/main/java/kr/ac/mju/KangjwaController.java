package kr.ac.mju;
//60102365 이건호
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KangjwaController {
	private static final Logger logger = LoggerFactory.getLogger(KangjwaController.class);
	
	@Autowired
	KangjwaService service;
	
	@RequestMapping(value = "/KangjwaController/kangjwagaseol.do", method = RequestMethod.POST)
	public String kangjwagaseol(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("utf-8");
		String professorID = request.getParameter("professorID");
		String professorName = request.getParameter("professorName");
		String kangjwaNumber = request.getParameter("kangjwaNumber");
		String kangjwaName = request.getParameter("kangjwaName");
		String kangjwaYear = request.getParameter("kangjwaYear");
		String kangjwaGrade = request.getParameter("kangjwaGrade");
		String kangjwaMember = request.getParameter("kangjwaMember");
		String kangjwaCredit = request.getParameter("kangjwaCredit");
		
		service.gaseol(professorID,professorName,kangjwaNumber,kangjwaName,kangjwaYear,kangjwaGrade,kangjwaMember,kangjwaCredit);
		return "kangjwa";
	}
	
	@RequestMapping(value = "/KangjwaController/mykangjwa.do", method = RequestMethod.POST)
	public String mykangjwa(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("utf-8");
		String PID = request.getParameter("PID");
		
		model.put("result", service.myKangjwa(PID));
		
		return "myKangjwa";
	}
	
	@RequestMapping(value = "/KangjwaController/seongjeok.do", method = RequestMethod.POST)
	public String seongjeok(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("utf-8");
		String KID = request.getParameter("KID");
		
		model.put("result", service.seongjeok(KID));
		
		return "seongjeok";
	}
	
	@RequestMapping(value = "/KangjwaController/seongjeokBuyeo.do", method = RequestMethod.POST)
	public String seongjeokBuyeo(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{
		request.setCharacterEncoding("utf-8");
		String SJK = request.getParameter("SJK");
		String KID = request.getParameter("KID");
		String SID = request.getParameter("SID");
		
		service.seongjeokBuyeo(SJK,KID,SID);
		model.put("result", service.seongjeok(KID));
		
		return "seongjeok";
	}
	
	@RequestMapping(value = "/KangjwaController/kangjwaClose", method = RequestMethod.GET)
	public String kangjwaClose(HttpServletRequest request) throws UnsupportedEncodingException{

		System.out.println("닫기");
		return "kangjwa";
	}
}
