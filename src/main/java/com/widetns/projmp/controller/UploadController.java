package com.widetns.projmp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
//	@GetMapping("/uploadForm")
//	public void uploadForm() {}
//	
//	@PostMapping("/uploadFormAction")
//	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
//		String uploadFolder = "C:\\Users\\user\\git\\widetns\\src\\main\\webapp\\resources\\img";
//		
//		for(MultipartFile multipartFile : uploadFile) {
//			log.info("------------------------");
//			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
//			log.info("Upload File Size: " + multipartFile.getSize());
//			
//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//			
//			try {
//				multipartFile.transferTo(saveFile);
//			}catch(Exception e) {
//				log.error(e.getMessage());
//			}
//		}
//	}
//	
//	@GetMapping("/uploadAjax")
//	public void uploadAjax() {}
//	
//	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<List<HashMap<String, Object>>> uploadAjaxPost(MultipartFile[] uploadFile) {
//		List<HashMap<String, Object>> list = new ArrayList<>();
//		
//		String uploadPath = "C:\\Users\\user\\git\\widetns\\src\\main\\webapp\\resources\\img";
//		
//		for(MultipartFile multipartFile : uploadFile) {
//			
//			HashMap<String, Object> img = new HashMap<>();
//			
//			log.info("------------------------");
//			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
//			log.info("Upload File Size: " + multipartFile.getSize());
//
//			String uploadFileName = multipartFile.getOriginalFilename();
//			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
//			
//			img.put("fileName", uploadFileName);
//			
//			//중복 방지를 위한 uuid
//			UUID uuid = UUID.randomUUID();
//			uploadFileName = uuid.toString()+"_"+uploadFileName;
//			
//			try {
//				File saveFile = new File(uploadPath, uploadFileName);
//				multipartFile.transferTo(saveFile);
//				
//				img.put("uuid", uuid.toString());
//				img.put("uploadPath", uploadPath);
//				
//				// 이미지 파일인지 체크
//				if(checkImageType(saveFile)) {
//					img.put("image", true);
//				}
//				list.add(img);
//			} catch(Exception e) {
//				log.error(e.getMessage());
//			}
//		}
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
//	
//	public HashMap<String, Object> getImg(){
//		
//	}
//	
//	private boolean checkImageType(File file) {
//		try {
//			String contentType = Files.probeContentType(file.toPath());
//			return contentType.startsWith("image");
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
}
