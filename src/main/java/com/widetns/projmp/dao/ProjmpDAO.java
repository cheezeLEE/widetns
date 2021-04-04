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
	
	//사원 사진 수정
	public void insertImg(HashMap<String, Object> img);
	
	//사번으로 사원 사진 찾기
//	public List<HashMap<String, Object>> findImg(int empNo);
	public HashMap<String, Object> findImg(int empNo);
	
}
