package com.widetns.projmp.dao;

import java.util.List;

import com.widetns.projmp.domain.EmployeeVO;
import com.widetns.projmp.domain.ProjectBasicVO;

public interface ProjmpDAO {
	
	//프로젝트 목록
	public List<ProjectBasicVO> projList();
	
	//프로젝트 검색
	
	
	//프로젝트 등록
	
	
	//프로젝트 수정
	
	
	//사원검색
	public EmployeeVO selectEmp(String kor_name);
	
	//사원추가
	
	
	//사원삭제
	
	
	//사원정보 수정
	
}
