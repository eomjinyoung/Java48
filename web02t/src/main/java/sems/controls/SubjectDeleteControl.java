package sems.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.dao.SubjectDao;

@Controller
@RequestMapping("/subject")
public class SubjectDeleteControl {
	static Logger log = Logger.getLogger(SubjectDeleteControl.class);
	
	@Autowired
	SubjectDao subjectDao;
	
	public SubjectDeleteControl() {
		log.debug("SubjectDeleteControl 생성됨");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String execute(int no) {
		try {
			subjectDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
















