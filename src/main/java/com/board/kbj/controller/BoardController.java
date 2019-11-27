package com.board.kbj.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.board.kbj.domain.BoardVO;
import com.board.kbj.domain.FileVO;
import com.board.kbj.service.BoardService;
import com.board.kbj.service.FileService;

@Controller
public class BoardController {

	@Resource(name = "com.board.kbj.service.BoardService")
	BoardService mBoardService;
	
	@Resource(name = "com.board.kbj.service.FileService")
	FileService mFileService;
	
	// application.properties에서 파일이 첨부될 위치 정보 가져오기
	@Value("${file.upload.path}")
	String uploadPath;
	
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
		return "boardRegister";
	}
	
	// Board Register 게시판 글 작성
	@RequestMapping(value="/boards/register", method=RequestMethod.POST)
	private String boardRegister(HttpServletRequest req, @RequestPart(required=false) MultipartFile[] files ) throws Exception {
		
		// 1. 글을 저장
		BoardVO board = new BoardVO();
		board.setBoardTitle(req.getParameter("title"));
		board.setBoardContent(req.getParameter("content"));
		board.setBoardWriter(req.getParameter("writer"));
		mBoardService.boardRegister(board); //DB에 글 저장
		
		//2. 먼저 파일을 저장하고, 저장된 파일 목록을 생성
		List<FileVO> fileList = new ArrayList<FileVO>();
		for(int a=0; a<files.length; a++) {
			// 파일 유무 확인 후, 있으면 파일 저장
			if( files[a].isEmpty())
				continue;
			String originalFileName = files[a].getOriginalFilename(); //파일의 원래 이름
			String uploadedFileName = RandomStringUtils.randomAlphanumeric(10)+"_"+originalFileName; // 중복 방지를 위해 저장될 랜덤값 + 파일 이름
			File fileToUpload = new File( System.getProperty("user.dir")+ uploadPath+ uploadedFileName );
			files[a].transferTo(fileToUpload);
			
			// 저장된 파일의 정보를 리스트로 보관
			FileVO fileInfo = new FileVO();
			fileInfo.setBoardId(board.getBoardId());
			fileInfo.setOriginalFileName(originalFileName);
			fileInfo.setSavedFileName(uploadedFileName);
			fileList.add(fileInfo);
		}
		
		//3. 저장된 파일 정보 리스트를 DB에 저장
		if(fileList.size()>0) {
			mFileService.fileRegister(fileList);
		}
		return "redirect:/boards/"+board.getBoardId();
	}
	
	// Board Detail 게시판 글 읽기
	@RequestMapping(value="/boards/{boardId}", method=RequestMethod.GET)
	private String boardDetail(@PathVariable int boardId, Model model) throws Exception {
		model.addAttribute("board", mBoardService.boardDetail(boardId)); // 글 정보
		model.addAttribute("fileList", mFileService.fileList(boardId)); // 글에 속한 첨부 파일 리스트
		return "boardDetail";
	}
		
}