package com.board.kbj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.kbj.domain.BoardVO;
import com.board.kbj.service.BoardService;

@Controller
public class BoardController {

	@Resource(name = "com.board.kbj.service.BoardService")
	BoardService mBoardService;
	
	@RequestMapping("/boardList")
	private String boardList() throws Exception {
		List<BoardVO> boardList = mBoardService.boardList();
		return "test";
	}
}