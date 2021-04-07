package com.widetns.projmp.service;

import java.util.HashMap;
import java.util.List;

public interface ProjmpService {
	// 프로젝트 목록
	public List<HashMap<String, Object>> projList();
	// 사원 목록
	public List<HashMap<String, Object>> empList();
	// 사원정보 상세보기 (emp_num = 1)
	public HashMap<String, Object> empDetail();
	// 사원정보 수정 (emp_num = 1)
	public void empUpdate(HashMap<String, Object> map);
	// 사원별 사용할 수 있는 기술
	public List<HashMap<String, Object>> empTech();
	// 공통코드 내 모든 기술목록
	public List<HashMap<String, Object>> allTech();
	// 해당 사원의 기술 추가
	public void addTech(HashMap<String, Object> map);
	// 해당 사원의 기술 삭제
	public void delTech(String tech);
	// 사원별 참여 프로젝트 목록
	public List<HashMap<String, Object>> empPrj();
}
