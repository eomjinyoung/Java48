package sems.controls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.services.AuthService;
import sems.services.UserGroup;
import sems.vo.UserVo;

@Controller
@RequestMapping("/auth")
public class AuthControl {
	static Logger log = Logger.getLogger(AuthControl.class);
	
	@Autowired
	AuthService authService;

	public AuthControl() {
		log.debug("AuthControl 생성됨");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "auth/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response) {
		try {
				UserVo userVo = authService.getLoginUser(
							email, password, UserGroup.STUDENT);
				if (userVo == null) {
					throw new RuntimeException("로그인 실패!");
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
	
	@RequestMapping("/logout")
  public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:login.bit";
  }
}










