package sems.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.services.SubjectService;
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
	public String list(
			@RequestParam(value="pageNo",defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize",defaultValue="10") int pageSize, 
			Model model) {
		model.addAttribute("list", subjectService.list(pageNo, pageSize));
		return "subject/list";
	}

	@RequestMapping("/detail")
	public String detail(int no, Model model) {
		model.addAttribute("subject", subjectService.detail(no));
		return "subject/detail";
	}

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String form() {
		return "subject/form";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(SubjectVo vo) {
		subjectService.add(vo);
		return "subject/insert";
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(int no, Model model) {
		model.addAttribute("subject", subjectService.detail(no));
		return "subject/updateform";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(SubjectVo vo, Model model) {
		subjectService.change(vo);
		return "redirect:detail.bit?no=" + vo.getNo();
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(int no) {
		subjectService.remove(no);
		return "redirect:list.bit?pageNo=1&pageSize=10";
	}
}














