package com.qa.userdata;

public class UserData {

	private String username;
	private String password;
	private String email;
	private int id;
	private int score;
	private int level;
	private int exp;

	public UserData(String username, String password, String email, int id, int score, int level, int exp) {

		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
		this.score = score;
		this.level = level;
		this.exp = exp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

}
