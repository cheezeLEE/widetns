package com.widetns.projmp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.widetns.projmp.service.ProjmpService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ProjmpController {
	
	@Autowired
	private ProjmpService service;

	HashMap<String, Object> img;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "/widetns/projmp/index";
	}
	
	// 프로젝트 목록보기
	@RequestMapping(value="/searchPrj", method=RequestMethod.GET)
	public String prjList(Model model) {
		model.addAttribute("list", service.projList());
		return "/widetns/projmp/searchPrj";
	};
	
	// 사원정보 수정 페이지
	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public String updateEmp(Model model) {
		model.addAttribute("empDetail", service.empDetail());
		return "/widetns/projmp/updateEmp";
	}
	
	@RequestMapping(value="/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@RequestParam HashMap<String, Object> map, MultipartFile uploadFile, RedirectAttributes rttr) {
		map.put("uuid", img.get("uuid"));
		map.put("fileName", img.get("fileName"));
		map.put("uploadPath", img.get("uploadPath"));
		service.empUpdate(map);

		return "redirect:/";
	}
	
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<HashMap<String, Object>>> uploadAjaxPost(MultipartFile[] uploadFile) {
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		String uploadPath = "C:\\Users\\user\\git\\widetns\\src\\main\\webapp\\resources\\img";
		
		for(MultipartFile multipartFile : uploadFile) {
			
			img = new HashMap<>();
			
			log.info("------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			img.put("fileName", uploadFileName);
			
			//중복 방지를 위한 uuid
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				img.put("uuid", uuid.toString());
				img.put("uploadPath", uploadPath);
				
				// 이미지 파일인지 체크
				if(checkImageType(saveFile)) {
					img.put("image", true);
				}
				list.add(img);
			} catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 사원 목록보기
	@RequestMapping(value = "/searchEmp", method = RequestMethod.GET)
	public String searchEmp(Model model) {
		model.addAttribute("emp", service.empList());
		return "/widetns/projmp/searchEmp";
	}
	
	@RequestMapping(value = "/writePrj", method = RequestMethod.GET)
	public String writePrj() {	
		return "/widetns/projmp/writePrj";
	}
	
	@RequestMapping(value = "/updatePrj", method = RequestMethod.GET)
	public String updatePrj() {
		return "widetns/projmp/updatePrj";
	}
}