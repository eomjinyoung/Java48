package sems.controls.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.DaoException;
import sems.dao.UserDao;
import sems.vo.UserVo;

@Controller
@RequestMapping("/auth/login")
public class LoginControl {
	@Autowired
	UserDao userDao;

	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "/auth/login.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String execute(
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response) {
		try {
				UserVo userVo = null;
				
				try {
					userVo = userDao.getUser(email, password);
				} catch (DaoException e) { // 로그인 실패!
					return "redirect:login.bit";
				}
				
				session.setAttribute("loginUser", userVo);
				
				if (saveEmail != null) {
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("t.java48.com"); // 서버 범위
					cookie.setPath("/web02t");					// 하위 폴더 범위
					
					response.addCookie(cookie);
				}
				
				return "redirect:../subject/list.bit?pageNo=1&pageSize=10";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}



















