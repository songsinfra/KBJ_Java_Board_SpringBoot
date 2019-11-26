package com.board.kbj.domain;

public class BoardVO {

	private int boardId; // 글 ID
	private String boardTitle; // 글 제목
	private String boardContent; // 글 내용
	private String boardWriteTime; // 글 작성 날짜
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriteTime() {
		return boardWriteTime;
	}
	public void setBoardWriteTime(String boardWriteTime) {
		this.boardWriteTime = boardWriteTime;
	}
	
}
