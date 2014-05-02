package sems.controls;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sems.vo.StudentVo;

@Controller
@RequestMapping("/student")
public class StudentControl {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String form() {
		return "/student/form.jsp";
	}
	
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String form2(StudentVo student) {
		return "/student/form2.jsp";
	}
	
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String form3(StudentVo student) {
		return "/student/insertResult.jsp";
	}

}






















