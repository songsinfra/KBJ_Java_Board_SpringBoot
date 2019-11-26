package com.board.kbj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.kbj.domain.BoardVO;


@Repository("com.board.kbj.mapper.BoardMapper")
public interface BoardMapper {

	// Board List 가져오기
	List<BoardVO> boardList() throws Exception;
	
}
