package sems.dao;

import sems.vo.UserVo;

public interface UserDao {
	UserVo getUser(String email, String password);
}
