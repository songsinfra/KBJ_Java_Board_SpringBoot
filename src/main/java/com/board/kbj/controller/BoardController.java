package com.board.kbj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.kbj.domain.BoardVO;
import com.board.kbj.service.BoardService;

@Controller
public class BoardController {

	@Resource(name = "com.board.kbj.service.BoardService")
	BoardService mBoardService;
	
	// Board List 게시판 글 목록 보여주기
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	private String boardList(Model model) throws Exception {
		List<BoardVO> boardList = mBoardService.boardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	// Move to Board Register 게시판 글 작성 페이지로 이동
	@RequestMapping(value="/boards/register", method=RequestMethod.GET)
	private String boardRegister() throws Exception {
		System.out.println("하하하하");
		return "boardRegister";
	}
	
	// Board Register 게시판 글 작성
	@RequestMapping(value="/boards/register", method=RequestMethod.POST)
	private String boardRegister(HttpServletRequest req) throws Exception {
		BoardVO board = new BoardVO();
		board.setBoardTitle(req.getParameter("title"));
		board.setBoardContent(req.getParameter("content"));
		board.setBoardWriter(req.getParameter("writer"));
		
		mBoardService.boardRegister(board);
		return "redirect:/boards/"+board.getBoardId();
	}
	
	// Board Detail 게시판 글 읽기
	@RequestMapping(value="/boards/{boardId}", method=RequestMethod.GET)
	private String boardRegister(@PathVariable int boardId, Model model) throws Exception {
		model.addAttribute("board", mBoardService.boardDetail(boardId));
		return "boardDetail";
	}
		
		
}