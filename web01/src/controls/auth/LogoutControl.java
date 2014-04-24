package controls.auth;

import java.util.Map;

import javax.servlet.http.HttpSession;

import controls.PageController;

public class LogoutControl implements PageController {
	HttpSession session;
	
	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
  public String execute(Map<String, Object> model) {
	  session.invalidate();
	  return "redirect:login.bit";
  }
	
}


















