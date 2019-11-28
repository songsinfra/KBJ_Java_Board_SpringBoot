package com.board.kbj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.kbj.utility.PasswordSecurity;
import com.board.kbj.domain.UserVO;
import com.board.kbj.service.UserService;

@Controller
public class UserController {

	@Resource(name = "com.board.kbj.service.UserService")
	UserService mUserService;
	
	// Move to User Join 회원가입 페이지로 이동
	@RequestMapping(value="/join", method=RequestMethod.GET)
	private String boardRegister() throws Exception {
		return "userRegister";
	}
	
	// User Join 회원가입 하기
	@RequestMapping(value="/join", method=RequestMethod.POST)
	private String boardRegister(HttpServletRequest req ) throws Exception {

		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		String passwordConfirm = req.getParameter("passwordConfirm");
		
		// 입력받은 패스워드 2개가 일치하지 않으면 가입 페이지로 되돌아간다
		if(!password.equals(passwordConfirm))
			return "redirect:/join";
		if(password == null || passwordConfirm == null || username == null )
			return "redirect:/join";
		
		// 패스워드 암호화, 암호화에 사용한 Salt는 원래 따로 보관하겠지만, 여기선 그냥 같이 DB에 저장
		String salt = PasswordSecurity.generateSalt();
		String hashedPassword = PasswordSecurity.getEncrypt(password, salt );
		
		// DB에 정보 저장
		UserVO user = new UserVO();
		user.setUsername(username);
		user.setPassword(hashedPassword); // 암호화 된 비밀번호
		user.setSalt(salt); // 암호화를 풀기 위한 키
		mUserService.userRegister(user);
		
		return "redirect:/";
	}
	

	// User Login 로그인 하기
	@RequestMapping(value="/login", method=RequestMethod.POST)
	private String userLogin(HttpServletRequest req ) throws Exception {
		
		return "redirect:/";
	}
	
}