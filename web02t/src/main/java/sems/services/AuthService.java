package sems.services;

import sems.vo.UserVo;

public interface AuthService {
	UserVo getLoginUser(String email, String password, UserGroup group);
}
