package sems.services;

import java.util.List;

import sems.vo.SubjectVo;

public interface SubjectService {
	void add(SubjectVo subject);
	List<SubjectVo> list(int pageNo, int pageSize);
	SubjectVo detail(int no);
	void change(SubjectVo subject);
	void remove(int no);
}
