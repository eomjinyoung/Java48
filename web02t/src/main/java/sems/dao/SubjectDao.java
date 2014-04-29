package sems.dao;

import java.util.List;

import sems.vo.SubjectVo;

public interface SubjectDao {
	void insert(SubjectVo subject) throws Throwable;
	List<SubjectVo> list(int pageNo, int pageSize) throws Throwable;
	SubjectVo detail(int no) throws Throwable;
	void update(SubjectVo subject) throws Throwable;
	void delete(int no) throws Throwable;
}









