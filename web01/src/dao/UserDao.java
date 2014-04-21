package dao;

import vo.UserVo;

public interface UserDao {
	UserVo getUser(String email, String password);
}
