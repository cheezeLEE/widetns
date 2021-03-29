package com.widetns.projmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widetns.projmp.dao.ProjmpDAO;
import com.widetns.projmp.domain.ProjectMappingVO;

@Service
public class ProjmpServiceImpl implements ProjmpService{

	@Autowired
	private ProjmpDAO dao;
	
//	@Override
//	public List<ProjectBasicVO> projList() {		
//		return dao.projList();
//	}
//	@Override
//	public List<ProjectMappingVO> projList() {		
//		return dao.projList();
//	}
}
