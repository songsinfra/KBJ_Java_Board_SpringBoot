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

		String username = req.getParameter("username").trim(); 
		String password = req.getParameter("password").trim();
		String passwordConfirm = req.getParameter("passwordConfirm").trim();
		
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
		String username = req.getParameter("username").trim(); 
		String password = req.getParameter("password").trim();
		
		if(password == null || username == null )
			return "redirect:/";
		
		// 비밀번호 암호화 해제를 위해 입력된 Username이 가지고 있는 Salt를 먼저 확인
		String salt = mUserService.userGetSalt(username);
		if(salt == null)
			return "redirect:/"; // 가입된 회원 아님
		// 비밀번호 암호화 해제
		String hashedPassword = PasswordSecurity.getEncrypt(password, salt );
		
		// DB에서 로그인 정보 확인
		UserVO user = new UserVO();
		user.setUsername(username);
		user.setPassword(hashedPassword); // 암호화 된 비밀번호
		String loginRes = mUserService.userLogin(user);
		
		
		// 로그인 성공시 세션 저장
		if(loginRes != null) {
			req.getSession().setAttribute("loginUser", username);
			req.getSession().setMaxInactiveInterval(60*60*2); //2시간 로그인 지속
			return "loginResult"; // 로그인 성공
		}
		return "redirect:/"; // 비밀번호 불일치로 로그인 실패
	}
	
	// User Logout 로그아웃 하기
	@RequestMapping(value="/logout")
	private String userLogout(HttpServletRequest req ) throws Exception {
		// 로그아웃
		req.getSession().removeAttribute("loginUser");
		return "redirect:/"; // 비밀번호 불일치로 로그인 실패
	}
	
}