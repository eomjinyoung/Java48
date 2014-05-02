package sems.controls;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.vo.StudentVo;

//@Controller
@RequestMapping("/student")
public class StudentControl01 {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;

	// 기본 정보 입력폼 출력 
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return "/student/insert.jsp";
	}
	
	// 기본 정보 입력값 받고 => 추가 정보 입력폼 출력 
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String insert2(StudentVo student, HttpSession session) {
		session.setAttribute("student", student);
		return "/student/insert2.jsp";
	}
	
	// 추가 정보 입력값 받고 => 전체 입력 값 출력 
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String insert3(StudentVo student, HttpSession session) {
		StudentVo basicInfo = 
				(StudentVo)session.getAttribute("student");
		basicInfo.setCompany(student.getCompany());
		basicInfo.setPosition(student.getPosition());
		basicInfo.setWorkingState(student.getWorkingState());
		basicInfo.setLastSchool(student.getLastSchool());
		basicInfo.setBankingAccount(student.getBankingAccount());
		
		return "/student/insert3.jsp";
	}
	
	// 기존에 입력했던 기본 정보과 추가 정보를 DB에 저장 
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String insert4() {
		return "/student/insert4.jsp";
	}

}






















