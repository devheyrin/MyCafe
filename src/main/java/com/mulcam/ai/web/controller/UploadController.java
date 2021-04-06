package com.mulcam.ai.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController // @Controller + @Responsbody // jsp로 보내지않고 out객체에 데이터를담겠다는것 
public class UploadController {
	
	@PostMapping("upload") // post 방식으로 보낸다는 뜻
	public void upload(@RequestParam("file") MultipartFile file) { 
		//텍스트를 다시 바이너리로 바꾸어야 하는데, 그걸 도와주는것이 MultipartFile- 이미지 후처리를 도와주는 객체
		//request 객체에 들어있는 file이라는 이름의 데이터를 함께보냄 
		System.out.println(file);
		try {
			file.transferTo(
					new File(
							"C:\\Users\\혜린\\TIL\\Multicampus2021\\Servlet\\tool\\temp\\"+file.getOriginalFilename()));
		
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
