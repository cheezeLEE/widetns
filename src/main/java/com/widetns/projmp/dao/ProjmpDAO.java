package com.widetns.projmp.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("ProjmpDAO")
public interface ProjmpDAO {
	
	//프로젝트 목록
//	public List<ProjectBasicVO> projList();
//	List<ProjectMappingVO> projList();
	public List<HashMap<String, Object>> projList();
	
	//프로젝트 검색
	
	
	//프로젝트 등록
	
	
	//프로젝트 수정
	
	
	//사원검색
	public List<HashMap<String, Object>> empList();
	
	//사원추가
	
	
	//사원삭제
	
	
	//사원정보 상세보기
	public HashMap<String, Object> empDetail();
	
	//사원정보 수정
	public void empUpdate(HashMap<String, Object> map);
	
	//사원별 사용할 수 있는 기술목록
	public List<HashMap<String, Object>> empTech();
	
	//해당 사원의 기술목록 전부삭제
	
	//새로 insert
	
	//사원별 참여 프로젝트 목록
	public List<HashMap<String, Object>> empPrj();
}
