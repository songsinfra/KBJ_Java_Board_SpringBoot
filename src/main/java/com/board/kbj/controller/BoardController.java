package com.board.kbj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.kbj.domain.BoardVO;
import com.board.kbj.service.BoardService;

@Controller
public class BoardController {

	@Resource(name = "com.board.kbj.service.BoardService")
	BoardService mBoardService;
	
	// 게시판 글 목록 보여주기
	@RequestMapping("/boardList")
	private String boardList(Model model) throws Exception {
		List<BoardVO> boardList = mBoardService.boardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
}