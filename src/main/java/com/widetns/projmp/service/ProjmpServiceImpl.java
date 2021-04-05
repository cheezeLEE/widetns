package com.widetns.projmp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widetns.projmp.dao.ProjmpDAO;

@Service
public class ProjmpServiceImpl implements ProjmpService{

	@Autowired
	private ProjmpDAO dao;
		
	@Override
	public List<HashMap<String, Object>> projList() {
		return dao.projList();
	}

	@Override
	public List<HashMap<String, Object>> empList() {
		return dao.empList();
	}

	@Override
	public HashMap<String, Object> empDetail() {
		return dao.empDetail();
	}

	@Override
	public void empUpdate(HashMap<String, Object> map) {
		dao.empUpdate(map);
	}

	@Override
	public List<HashMap<String, Object>> empTech() {
		return dao.empTech();
	}

	@Override
	public List<HashMap<String, Object>> empPrj() {
		return dao.empPrj();
	}
}
