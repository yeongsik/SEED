package model;

import java.sql.Timestamp;

public class ShareDTO {
	private int share_num;				// 글번호
	private String name;				// 닉네임
	private String share_site;			// 사이트이름
	private String share_des;			// 사이트 설명(내용)
	private String share_link;			// 사이트 링크
	private int share_view;				// 조회수
	private Timestamp share_register;	// 작성일
	
	
	public int getShare_num() {
		return share_num;
	}
	public void setShare_num(int share_num) {
		this.share_num = share_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShare_site() {
		return share_site;
	}
	public void setShare_site(String share_site) {
		this.share_site = share_site;
	}
	public String getShare_des() {
		return share_des;
	}
	public void setShare_des(String share_des) {
		this.share_des = share_des;
	}
	public String getShare_link() {
		return share_link;
	}
	public void setShare_link(String share_link) {
		this.share_link = share_link;
	}
	public int getShare_view() {
		return share_view;
	}
	public void setShare_view(int share_view) {
		this.share_view = share_view;
	}
	public Timestamp getShare_register() {
		return share_register;
	}
	public void setShare_register(Timestamp share_register) {
		this.share_register = share_register;
	}
	
	
	
}
