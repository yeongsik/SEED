package model;

import java.sql.Timestamp;

public class TipDTO {
	private int board_num;
	private String board_category;
	private String name;
	private String board_subject;
	private String board_content;
	private Timestamp board_register;
	private int board_view;
	private int board_like;
	private int board_hate;
	
	/* 댓글부분 */
	private int re_num;
	/* private String re_name; */
	private String re_content;
	private Timestamp re_register;
	private int re_like;
	private int re_hate;
	private int re_ref;
	private int re_lev;
	private int re_seq;
	
	
	
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Timestamp getBoard_register() {
		return board_register;
	}
	public void setBoard_register(Timestamp board_register) {
		this.board_register = board_register;
	}
	public int getBoard_view() {
		return board_view;
	}
	public void setBoard_view(int board_view) {
		this.board_view = board_view;
	}
	public int getBoard_like() {
		return board_like;
	}
	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}
	public int getBoard_hate() {
		return board_hate;
	}
	public void setBoard_hate(int board_hate) {
		this.board_hate = board_hate;
	}
	
	/* 댓글 부분 */
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Timestamp getRe_register() {
		return re_register;
	}
	public void setRe_register(Timestamp re_register) {
		this.re_register = re_register;
	}
	public int getRe_like() {
		return re_like;
	}
	public void setRe_like(int re_like) {
		this.re_like = re_like;
	}
	public int getRe_hate() {
		return re_hate;
	}
	public void setRe_hate(int re_hate) {
		this.re_hate = re_hate;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	
}
