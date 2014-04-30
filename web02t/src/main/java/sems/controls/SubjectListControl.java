package sems.controls;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

@Component("/subject/list.bit")
public class SubjectListControl implements PageController {
	@Autowired
	SubjectDao subjectDao;

	@Override
  public String execute(Map<String, Object> model) {
		try {
			int pageNo = Integer.parseInt((String)model.get("pageNo")); 
			int pageSize = Integer.parseInt((String)model.get("pageSize")); 
			List<SubjectVo> list = subjectDao.list(pageNo, pageSize);
			model.put("list", list);
			return "/subject/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
  }

}













