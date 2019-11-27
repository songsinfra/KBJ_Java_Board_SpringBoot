package com.board.kbj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.kbj.domain.BoardVO;
import com.board.kbj.domain.FileVO;
import com.board.kbj.mapper.BoardMapper;
import com.board.kbj.mapper.FileMapper;

@Service("com.board.kbj.service.FileService")
public class FileService {

	@Resource(name = "com.board.kbj.mapper.FileMapper")
	FileMapper mFileMapper;
	
	public List<FileVO> fileList(int boardId) throws Exception {
		return mFileMapper.fileList(boardId);
	}
	
	public int fileRegister(List<FileVO> fileList) throws Exception {
		return mFileMapper.fileRegister(fileList);
	}
	
	public FileVO fileDetail(int boardId) throws Exception {
		return mFileMapper.fileDetail(boardId);
	}
	
}
