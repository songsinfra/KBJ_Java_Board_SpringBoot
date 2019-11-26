package com.board.kbj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping("/test")
	private String boardList() {
		return "test";
	}
}