package controls;

import java.util.List;
import java.util.Map;

import annotations.Component;
import vo.SubjectVo;
import dao.SubjectDao;

@Component("/subject/list.bit")
public class SubjectListControl implements PageController {
	SubjectDao subjectDao;

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

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













