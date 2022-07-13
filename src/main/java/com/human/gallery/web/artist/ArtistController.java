package com.human.gallery.web.artist;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ArtistController {
	
	@Autowired
    private ServletContext servletContext;
	
	@RequestMapping("/artist")
	public String viewArtist() {
		
		return "artist";
	}
	@RequestMapping("/artist/upload") 
	public String viewUpload() {
		
		return "artist/uploadArtist";
	}
	@RequestMapping(value = "/artist/asd", method = RequestMethod.POST)
	public String doUpload(@RequestParam("name") String name,
							@RequestParam("career") String career,
							@RequestParam("direction") String direction,
							@RequestParam("file") MultipartFile file,
							HttpSession session) throws IllegalStateException, IOException {
		
		log.info("name = {}", name);
		log.info("career = {}", career);
		log.info("direction = {}", direction);
		log.info("MultipartFile = {}", file);
		
		String fileDir = session.getServletContext().getRealPath("/resources/artist/");
		log.info("파일 저장 경로 = {}", fileDir);
		
		if (!file.isEmpty()) {
			String fullPath = fileDir + file.getOriginalFilename();
			log.info("파일 저장 fullPath = {}", fullPath);
			file.transferTo(new File(fullPath));
		}
		return null;
	}
	public String aaa() {
		return null;
	}
}
