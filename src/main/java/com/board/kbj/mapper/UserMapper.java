package com.board.kbj.mapper;


import org.springframework.stereotype.Repository;

import com.board.kbj.domain.UserVO;


@Repository("com.board.kbj.mapper.UserMapper")
public interface UserMapper {

	// User Register 회원가입 하기
	int userRegister(UserVO user) throws Exception;
	
}
