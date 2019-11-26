package com.board.kbj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.kbj.domain.BoardVO;
import com.board.kbj.mapper.BoardMapper;

@Service("com.board.kbj.service.BoardService")
public class BoardService {

	@Resource(name = "com.board.kbj.mapper.BoardMapper")
	BoardMapper mBoardMapper;
	
	public List<BoardVO> boardList() throws Exception {
		return mBoardMapper.boardList();
	}
	
}
