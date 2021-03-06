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
	
	public List<BoardVO> boardList(int startBoardNum, int boardCountInPage) throws Exception {
		return mBoardMapper.boardList(startBoardNum, boardCountInPage);
	}
	
	public int boardTotalCount() throws Exception{
		return mBoardMapper.boardTotalCount();
	}
	
	public int boardRegister(BoardVO board) throws Exception {
		return mBoardMapper.boardRegister(board);
	}
	
	public BoardVO boardDetail(int boardId) throws Exception {
		return mBoardMapper.boardDetail(boardId);
	}

	public void boardDelete(int boardId) throws Exception{
		mBoardMapper.boardDelete(boardId);
	}
	
}
