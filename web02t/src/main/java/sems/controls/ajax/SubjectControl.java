package sems.controls.ajax;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.services.SubjectService;
import sems.vo.AjaxResult;
import sems.vo.SubjectVo;

@Controller
@RequestMapping("/subject")
public class SubjectControl {
	static Logger log = Logger.getLogger(SubjectControl.class);

	@Autowired
	SubjectService subjectService;

	public SubjectControl() {
		log.debug("SubjectControl 생성됨");
	}

	@RequestMapping("/list")
	public AjaxResult list(
			@RequestParam(value="pageNo",defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize",defaultValue="10") int pageSize) {
		
		return new AjaxResult()
			.setStatus("ok")
			.setData(subjectService.list(pageNo, pageSize));
	}

	@RequestMapping("/detail")
	public AjaxResult detail(int no, Model model) {
		SubjectVo s = subjectService.detail(no);
		if (s != null) {
			return new AjaxResult()
				.setStatus("ok")
				.setData(s);
		} else {
			return new AjaxResult().setStatus("failure");
		}
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public AjaxResult insert(SubjectVo vo) {
		subjectService.add(vo);
		return new AjaxResult().setStatus("ok");
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public AjaxResult update(SubjectVo vo, Model model) {
		subjectService.change(vo);
		return new AjaxResult().setStatus("ok");
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public AjaxResult delete(int no) {
		subjectService.remove(no);
		return new AjaxResult().setStatus("ok");
	}
}














