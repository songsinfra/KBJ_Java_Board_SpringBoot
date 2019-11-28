package com.board.kbj.mapper;


import org.springframework.stereotype.Repository;

import com.board.kbj.domain.UserVO;


@Repository("com.board.kbj.mapper.UserMapper")
public interface UserMapper {

	// User Register 회원가입 하기
	int userRegister(UserVO user) throws Exception;

	// User 로그인 전, 비밀번호 암호화 해제를 위한 Salt 가져오기
	String userGetSalt(String username) throws Exception;
	
	// User Login 회원 로그인 하기
	String userLogin(UserVO user) throws Exception;

	
	
}
