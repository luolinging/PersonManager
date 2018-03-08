package com.person.action;

import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.person.service.UserService;
import com.person.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String id;
	private String name;
	private String psd;
	private UserService service = new UserService();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String login() throws Exception {
		user = service.checkLogin(name, psd);
		return "login";
	}

	@SkipValidation
	public String form() throws Exception {
		return INPUT;
	}

	public String logout() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		User logined = (User) session.get("user");
		if (logined != null) {
			String paramId = id;
			if (paramId != null && !paramId.isEmpty()) {
				if (logined.getId() == Integer.parseInt(paramId))
					session.remove("user");
			}
			user = service.checkLogin(name, psd);
			return "login";
		}
		return "logout";
	}
}
