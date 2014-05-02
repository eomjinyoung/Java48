package sems.dao;

import java.util.Map;

import sems.vo.StudentVo;

public interface StudentDao {
	void insert(StudentVo student);
	StudentVo getLoginUser(Map<String,String> params);
}
