package com.board.kbj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.kbj.domain.BoardVO;


@Repository("com.board.kbj.mapper.BoardMapper")
public interface BoardMapper {

	// Board List 가져오기
	List<BoardVO> boardList() throws Exception;
	
	// Board Register 글 등록하기
	int boardRegister(BoardVO board) throws Exception;
	
	//Board Detail 글 읽기
	BoardVO boardDetail(int boardId) throws Exception;

	// Board Delete 글 삭제
	void boardDelete(int boardId);
}
