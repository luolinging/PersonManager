package com.person.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.person.service.UserService;
import com.person.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private String rePsd;
	private String name;
	private String psd;
	private List<User> list;
	private String userId;

	private UserService service = new UserService();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRePassword() {
		return rePsd;
	}

	public void setRePsd(String rePsd) {
		this.rePsd = rePsd;
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

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String register() throws Exception {
		service.save(user);
		return "register";
	}

	@SkipValidation
	public String userList() throws Exception {
		list = service.getUser();
		return "getUsers";
	}

	@SkipValidation
	public String getUserEdit() throws Exception {
		user.setId(Integer.parseInt(userId));
		user = service.getUser(user.getId());
		return "getUser";
	}

	// public String login() throws Exception {
	// user = service.checkLogin(name, password);
	// return "login";
	// }
	//
	// @SkipValidation
	// public String form() throws Exception {
	// return INPUT;
	// }
}
