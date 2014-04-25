package controls.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import annotations.Component;
import vo.UserVo;
import controls.PageController;
import dao.DaoException;
import dao.UserDao;

@Component("/auth/login.bit")
public class LoginControl implements PageController {
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String execute(Map<String, Object> model) {
		try {
			if (model.get("email") == null) { // 로그인 폼 출력 
				return "/auth/login.jsp";
				
			} else { // 로그인 수행 
				String email = (String)model.get("email");
				String password = (String)model.get("password");
				String saveEmail = (String)model.get("saveEmail");
				
				UserVo userVo = null;
				
				try {
					userVo = userDao.getUser(email, password);
				} catch (DaoException e) { // 로그인 실패!
					return "redirect:login.bit";
				}
				
				HashMap<String,Object> sessionMap = new HashMap<String,Object>();
				sessionMap.put("loginUser", userVo);
				model.put("sessionMap", sessionMap);
				
				if (saveEmail != null) {
					ArrayList<Cookie> cookies = new ArrayList<Cookie>();
					
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("t.java48.com"); // 서버 범위
					cookie.setPath("/web01t");					// 하위 폴더 범위
					
					cookies.add(cookie);
					model.put("cookies", cookies);
				}
				
				return "redirect:../subject/list.bit?pageNo=1&pageSize=10";
			}
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}



















