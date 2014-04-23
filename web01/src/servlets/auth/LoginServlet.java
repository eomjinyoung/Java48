package servlets.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.UserVo;
import dao.UserDao;

/* 쿠키(Cookie)
 * - 클라이언트에 맡겨 놓는 정보 
 * - 이름=값 형태로 맡긴다. 이름과 값은 반드시 문자열이다.
 * - 응답헤더(Set-Cookie)에 포함하여 웹브라우저에게 보낸다.
 * - 맡겨 놓은 정보는 서버에 요청할 때 마다 웹 브라우저가 보내게 된다.
 * 
 * 주요 메서드
 * - setMaxAge(초): 
 *            유효기간을 지정하지 않으면, 웹 브라우저를 닫기 전까지 유지된다. 
 */

//@WebServlet("/auth/login.bit")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			// 쿠키 정보 꺼내기
			/*
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("loginEmail")) {
						request.setAttribute("loginEmail", cookie.getValue());
						break;
					}
				}
			}
			*/
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/auth/login.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String saveEmail = request.getParameter("saveEmail");
			
			UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			
			UserVo userVo = null;
			try {
				// DB에서 사용자 정보 조회
				// 만약, 일치하는 사용자가 있다면
				// => 사용자 기본정보(이메일, 전화, 이름)를 가져와서 세션에 보관한다.
				userVo = dao.getUser(email, password);
				
				// getSession();
			  // - JSESSIONID(요청헤더의 쿠키정보)로 세션 객체를 찾아서 리턴한다.
				// - 만약 JSESSIONID에 해당하는 세션 객체를 찾지 못하면 새로 생성.
				// 					(세션이 타임아웃되어서 무효처리된 경우)
				//   JSESSIONID 쿠키 값이 요청 헤더에 없으면 새로 생성 
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", userVo);
				
			} catch (Throwable ex) {
			// 그 밖에, 일치하는 사용자가 없다면
				// => 로그인 입력폼 페이지로 보낸다.
				response.sendRedirect("login.bit");
				return;
			}
			
			if (saveEmail != null) {
				// 쿠키를 응답 헤더에 포함한다.
				Cookie cookie = new Cookie("loginEmail", email);
				
				// 웹 브라우저에서 쿠키를 보낼 수 있는 URL 범위를 지정한다.
				// 만약 URL 범위를 지정하지 않으면, 
				// 쿠키를 생성한 서블릿과 같은 폴더에 대해서만 제한한다.
				cookie.setDomain("t.java48.com"); // 서버 범위
				cookie.setPath("/web01t");					// 하위 폴더 범위
				
				// 유효기간 지정
				//cookie.setMaxAge(40);
				
				response.addCookie(cookie);
			}
			
			response.sendRedirect("../subject/list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















