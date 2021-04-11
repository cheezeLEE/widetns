package com.widetns.projmp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	HashMap<String, Object> img = new HashMap<>();
	
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
		model.addAttribute("empTech", service.empTech());
		model.addAttribute("allTech", service.allTech());
		model.addAttribute("empPrj", service.empPrj());
		return "/widetns/projmp/updateEmp";
	}
	
	// 사원정보 수정 작업 진행
	@RequestMapping(value="/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@RequestParam HashMap<String, Object> map, MultipartFile uploadFile, RedirectAttributes rttr) {
		if(img.get("file_name") != null) {
			map.put("file_name", img.get("file_name"));
		} else {
			map.put("file_name", map.get("file_name"));
		}
		service.empUpdate(map);
//		Iterator<String> keys = map.keySet().iterator();
//		while(keys.hasNext()) {
//			String key = keys.next();
//			Object value = map.get(key);
//			log.info(key + ":" + value);
//		}
		return "redirect:/";
	}
	
	// ajax로 추가된 데이터를 처리하는 메소드 (rest)
	@RequestMapping(value="/addTech", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> addTech(@RequestBody HashMap<String, Object> map) {
//		log.info("addTech() : "+map.get("tech_code")+","+map.get("tech_level"));
		service.addTech(map);
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	// ajax로 삭제된 데이터를 처리
	@RequestMapping(value="/delTech", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<String>> delTech(@RequestBody ArrayList<String> delList){
		for(int i=0; i<delList.size();i++) {
			log.info(delList.get(i));
			service.delTech(delList.get(i));
		};
		return new ResponseEntity<>(delList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<HashMap<String, Object>>> uploadAjaxPost(MultipartFile[] uploadFile) {
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		String uploadPath = "C:\\Users\\user\\git\\widetns\\src\\main\\webapp\\resources\\img";
		
		for(MultipartFile multipartFile : uploadFile) {

			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			//중복 방지를 위한 uuid
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+uploadFileName;

			img.put("file_name", uploadFileName);
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				list.add(img);
			} catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
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