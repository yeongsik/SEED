// DTO ( Data Transfer Objecct )
package model;

import java.sql.Timestamp;

public class MemberDTO {
	private String id;
	private String name;
	private String pw;
	private Timestamp signup_date;
	private String profile;
	
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Timestamp getSignup_date() {
		return signup_date;
	}
	public void setSignup_date(Timestamp signup_date) {
		this.signup_date = signup_date;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
