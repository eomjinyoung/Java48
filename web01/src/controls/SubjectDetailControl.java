package controls;

import java.util.Map;

import annotations.Component;
import vo.SubjectVo;
import dao.SubjectDao;

@Component("/subject/detail.bit")
public class SubjectDetailControl implements PageController {
	SubjectDao subjectDao;

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		try {
			int no = Integer.parseInt((String)model.get("no")); 
			SubjectVo subject = subjectDao.detail(no);
			model.put("subject", subject);
			return "/subject/detail.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}





















