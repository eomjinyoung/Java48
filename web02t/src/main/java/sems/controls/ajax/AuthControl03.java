package sems.controls.ajax;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sems.services.AuthService;
import sems.services.UserGroup;
import sems.vo.AjaxResult;
import sems.vo.UserVo;

import com.google.gson.Gson;

//@Controller
@RequestMapping("/auth")
public class AuthControl03 {
	static Logger log = Logger.getLogger(AuthControl03.class);
	
	@Autowired
	AuthService authService;
	
	/* 리턴 타입이 HttpEntity인 경우, JSP를 인클루드 하지 않고,
	 * HttpEntity의 내용을 클라이언트로 보낸다.
	 */
	@RequestMapping("/login")
	public HttpEntity<String> login(
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response,
			Model model) {
		try {
				UserVo userVo = authService.getLoginUser(
							email, password, UserGroup.STUDENT);
				
				AjaxResult result = null;
				if (userVo == null) {
					result =  new AjaxResult().setStatus("ok").setData("failure");
					
				} else {
					result = new AjaxResult().setStatus("ok")	.setData("success");
					session.setAttribute("loginUser", userVo);
					
					if (saveEmail.equals("true")) {
						Cookie cookie = new Cookie("loginEmail", email);
						cookie.setDomain("t.java48.com"); // 서버 범위
						cookie.setPath("/web02t");					// 하위 폴더 범위
						
						response.addCookie(cookie);
					}
				}
				
				response.setContentType("text/html;charset=UTF-8");
				
				return new HttpEntity<String>(new Gson().toJson(result));
				
				/*
				HttpHeaders respHeaders = new HttpHeaders();
				respHeaders.add("Content-Type", "text/plain;charset=UTF-8");
				return new HttpEntity<String>(
						new Gson().toJson(result), respHeaders);
				*/
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










