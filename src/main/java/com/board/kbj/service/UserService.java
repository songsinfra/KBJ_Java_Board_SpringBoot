package com.board.kbj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.kbj.domain.UserVO;
import com.board.kbj.mapper.UserMapper;

@Service("com.board.kbj.service.UserService")
public class UserService {

	@Resource(name = "com.board.kbj.mapper.UserMapper")
	UserMapper mUserMapper;
	
	public int userRegister(UserVO user) throws Exception {
		return mUserMapper.userRegister(user);
	}

	public String userGetSalt(String username) throws Exception {
		return mUserMapper.userGetSalt(username);
	}
	
	public String userLogin(UserVO user) throws Exception {
		return mUserMapper.userLogin(user);
	}

	public UserVO userDuplicateCheck(String username) throws Exception  {
		return mUserMapper.userDuplicateCheck(username);
	}
	
}
