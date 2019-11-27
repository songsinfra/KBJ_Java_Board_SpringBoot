package com.board.kbj.domain;

public class FileVO {

	private int fileId; // 파일 ID
	private String originalFileName; // 파일의 원래 이름
	private String savedFileName; // 중복 방지를 위한 랜덤스트링 포함한 파일 이름
	private int boardId; // 연결된 글 번호
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	
}
