package sems.dao;

import java.util.List;
import java.util.Map;

import sems.vo.SubjectVo;

public interface SubjectDao {
	void insert(SubjectVo subject) throws Throwable;
	List<SubjectVo> list(Map<String,Integer> params) throws Throwable;
	SubjectVo detail(int no) throws Throwable;
	void update(SubjectVo subject) throws Throwable;
	void delete(int no) throws Throwable;
}









