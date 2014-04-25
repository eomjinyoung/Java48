package controls.auth;

import java.util.Map;

import javax.servlet.http.HttpSession;

import annotations.Component;
import controls.PageController;

@Component("/auth/logout.bit")
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


















