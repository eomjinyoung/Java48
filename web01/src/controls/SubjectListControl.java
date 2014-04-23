package controls;

import java.util.List;
import java.util.Map;

import vo.SubjectVo;
import dao.SubjectDao;

public class SubjectListControl implements PageController {
	SubjectDao subjectDao;

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
  public String execute(Map<String, Object> model) {
		int pageNo = Integer.parseInt((String)model.get("pageNo")); 
		int pageSize = Integer.parseInt((String)model.get("pageSize")); 
		
		try {
			List<SubjectVo> list = subjectDao.list(pageNo, pageSize);
			model.put("list", list);
		} catch (Throwable ex) {
			throw new Error(ex);
		}
		
		return "/subject/list.jsp";
  }

}













