package com.board.kbj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	// Error 발생시 Error 처리
	@RequestMapping(value="/error")
	private String boardList() throws Exception {
		return "error";
	}

}