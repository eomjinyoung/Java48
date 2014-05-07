package sems.controls.ajax;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.services.AuthService;
import sems.services.UserGroup;
import sems.vo.AjaxResult;
import sems.vo.UserVo;

//@Controller
@RequestMapping("/auth")
public class AuthControl02 {
	static Logger log = Logger.getLogger(AuthControl02.class);
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response,
			Model model) {
		try {
				UserVo userVo = authService.getLoginUser(
							email, password, UserGroup.STUDENT);
				if (userVo == null) {
					model.addAttribute("result", new AjaxResult()
											.setStatus("ok")
											.setData("failure"));
					
				} else {
					model.addAttribute("result",  new AjaxResult()
											.setStatus("ok")
											.setData("success"));
					session.setAttribute("loginUser", userVo);
					
					if (saveEmail.equals("true")) {
						Cookie cookie = new Cookie("loginEmail", email);
						cookie.setDomain("t.java48.com"); // 서버 범위
						cookie.setPath("/web02t");					// 하위 폴더 범위
						
						response.addCookie(cookie);
					}
				}
				
				return "auth/ajax/loginResult";
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










