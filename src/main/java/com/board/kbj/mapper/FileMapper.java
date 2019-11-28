package com.board.kbj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.kbj.domain.FileVO;


@Repository("com.board.kbj.mapper.FileMapper")
public interface FileMapper {

	// 특정 글에 해당하는 File List 가져오기
	List<FileVO> fileList(int boardId) throws Exception;
	
	// 특정 글에 연관된 파일 리스트 저장
	int fileRegister(List<FileVO> fileList) throws Exception;
	
	// 특정 파일 가져오기
	FileVO fileDetail(int fileId) throws Exception;

	// 파일 목록 삭제
	void fileDelete(List<FileVO> fileList);
}
