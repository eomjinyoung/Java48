package sems.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDao subjectDao;
	
	@Override
  public void add(SubjectVo subject) {
		try {
			subjectDao.insert(subject);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
  }

	@Override
  public List<SubjectVo> list(int pageNo, int pageSize) {
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("startIndex", (pageNo - 1) * pageSize);
			params.put("pageSize", pageSize);
			
			return subjectDao.list(params);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
  }

	@Override
  public SubjectVo detail(int no) {
		try {
			return subjectDao.detail(no);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
  }

	@Override
  public void change(SubjectVo subject) {
		try {
			subjectDao.update(subject);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
  }

	@Override
  public void remove(int no) {
		try {
			subjectDao.delete(no);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
  }

}







