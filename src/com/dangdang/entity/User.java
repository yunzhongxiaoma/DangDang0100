package com.dangdang.entity;

public class User {
	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private int accountstate;	//0代表true代表正常，1代表false代表冻结
	
	public User() {
		super();
	}

	public User(String email, String nickname, String password,
			int accountstate) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.accountstate = accountstate;
	}

	public User(Integer id, String email, String nickname, String password,
			int accountstate) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.accountstate = accountstate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname
				+ ", password=" + password + ", accountstate="
				+ accountstate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountstate() {
		return accountstate;
	}

	public void setAccountstate(int accountstate) {
		this.accountstate = accountstate;
	}
}
