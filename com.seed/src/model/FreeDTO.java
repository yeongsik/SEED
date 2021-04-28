// DTO (Data Transfer Object)

package model;

import java.sql.Timestamp;

public class FreeDTO {
	private int board_num;			// 게시물 번호
	private String name;			// 이름
	private String board_category;	// 카테고리
	private String board_subject;	// 제목
	private String board_content;	// 내용
	private Timestamp board_register;	// 작성시간
	private int board_view;			// 조회수
	private int board_like;			// 좋아요
	private int board_hate;			// 싫어요

	public int getBoard_num() {
		return board_num;
	}

	public String getName() {
		return name;
	}

	public String getBoard_category() {
		return board_category;
	}

	public String getBoard_subject() {
		return board_subject;
	}

	public String getBoard_content() {
		return board_content;
	}

	public Timestamp getBoard_register() {
		return board_register;
	}

	public int getBoard_view() {
		return board_view;
	}

	public int getBoard_like() {
		return board_like;
	}

	public int getBoard_hate() {
		return board_hate;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public void setBoard_register(Timestamp board_register) {
		this.board_register = board_register;
	}

	public void setBoard_view(int board_view) {
		this.board_view = board_view;
	}

	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}

	public void setBoard_hate(int board_hate) {
		this.board_hate = board_hate;
	}

}
