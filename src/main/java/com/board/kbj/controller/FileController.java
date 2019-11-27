package com.board.kbj.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.kbj.domain.FileVO;
import com.board.kbj.service.FileService;

@Controller
public class FileController {

	@Resource(name = "com.board.kbj.service.FileService")
	FileService mFileService;
	
	// application.properties에서 파일이 첨부될 위치 정보 가져오기
	@Value("${file.upload.path}")
	String uploadPath;
	
	// File 다운로드 요청
	@RequestMapping(value="/files/{fileId}/download", method=RequestMethod.GET)
	private String fileDownload(HttpServletRequest req, HttpServletResponse res, @PathVariable int fileId, Model model) throws Exception {
		
		try{
			FileVO fileInfo = mFileService.fileDetail(fileId);
			
            String saveFolderPath = System.getProperty("user.dir")+ uploadPath; // 파일이 저장된 위치
            String savedFileName = fileInfo.getSavedFileName(); // 서버에 저장된 이름
            String originalFileName = fileInfo.getOriginalFileName(); // 실제 내보낼 파일 명
            
            InputStream in = null;
            OutputStream os = null;
            File file = null;
            boolean skip = false;
            String client = "";
            
            //파일을 읽어 스트림에 담기  
            try{
                file = new File(saveFolderPath, savedFileName);
                in = new FileInputStream(file);
            } catch (FileNotFoundException fe) {
                skip = true;
            }
            
            client = req.getHeader("User-Agent");
            
            //파일 다운로드 헤더 지정 
            res.reset();
            res.setContentType("application/octet-stream");
            res.setHeader("Content-Description", "JSP Generated Data");
            
            if (!skip) {
                // IE
                if (client.indexOf("MSIE") != -1) {
                	res.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                    // IE 11 이상.
                } else if (client.indexOf("Trident") != -1) {
                	res.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                } else {
                    // 한글 파일명 처리
                	res.setHeader("Content-Disposition",
                            "attachment; filename=\"" + new String(originalFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                	res.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
                }
                res.setHeader("Content-Length", "" + file.length());
                os = res.getOutputStream();
                byte b[] = new byte[(int) file.length()];
                int leng = 0;
                while ((leng = in.read(b)) > 0) {
                    os.write(b, 0, leng);
                }
            } else {
            	res.setContentType("text/html;charset=UTF-8");
                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
            }
            in.close();
            os.close();
        } catch (Exception e) {
        	System.out.println(e.toString());
            System.out.println("ERROR : " + e.getMessage());
        }
		
		return "boardDetail";
	}
		
}