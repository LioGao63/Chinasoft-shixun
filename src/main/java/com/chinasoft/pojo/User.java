package com.chinasoft.pojo;


public class User{
	private Long uid;

	private String uname;

	private String user;

	private String password;

	private String image;

	private Integer state;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public User(Long uid, String uname, String user, String password, String image, Integer state) {
		this.uid = uid;
		this.uname = uname;
		this.user = user;
		this.password = password;
		this.image = image;
		this.state = state;
	}

	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				", uname='" + uname + '\'' +
				", user='" + user + '\'' +
				", password='" + password + '\'' +
				", image='" + image + '\'' +
				", state=" + state +
				'}';
	}
}
