package com.widetns.projmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.widetns.projmp.service.ProjmpService;

@Controller
public class ProjmpController {
	

	@Autowired
	private ProjmpService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "/widetns/projmp/index";
	}
		
	@RequestMapping(value="/searchPrj", method=RequestMethod.GET)
	public String prjList(Model model) {
//		model.addAttribute("list", service.projList());
		return "/widetns/projmp/searchPrj";
	};

	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public String updateEmp() {	
		return "/widetns/projmp/updateEmp";
	}
	
	@RequestMapping(value = "/searchEmp", method = RequestMethod.GET)
	public String searchEmp() {	
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
