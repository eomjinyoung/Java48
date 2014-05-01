package sems.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

@Controller
@RequestMapping
public class SubjectInsertControl {
	static Logger log = Logger.getLogger(SubjectInsertControl.class);

	@Autowired
	SubjectDao subjectDao;
	
	public SubjectInsertControl() {
		log.debug("SubjectInsertControl 생성됨");
	}
	
	@RequestMapping(value="/subject/insert", method=RequestMethod.GET)
	public String form() {
			return "/subject/form.jsp";
	}
	
	// 만약 메서드의 리턴 타입이 void이면,
	// 요청 URL과 일치하는 JSP를 자동으로 찾는다.
	@RequestMapping(value="/subject/insert", method=RequestMethod.POST)
	public String insert(SubjectVo vo) {
			try {
				subjectDao.insert(vo);
				return "/subject/insert.jsp";
			} catch (Throwable ex) {
				throw new Error(ex);
			}
	}
}




















