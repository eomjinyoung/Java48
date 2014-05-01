package sems.dao;

import java.util.Map;

import sems.vo.UserVo;

public interface UserDao {
	UserVo getUser(Map<String,String> params);
}
