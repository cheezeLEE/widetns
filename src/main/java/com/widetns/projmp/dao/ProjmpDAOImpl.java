package com.widetns.projmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.widetns.projmp.domain.EmployeeVO;
import com.widetns.projmp.domain.ProjectBasicVO;

@Repository
public class ProjmpDAOImpl implements ProjmpDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String SelectEmp = "ProjmpMapper.selectEmp";
	private static final String SelectProj = "ProjmpMapper.projList";
	
	@Override
	public EmployeeVO selectEmp(String kor_name) {
		return sqlSession.selectOne(SelectEmp, kor_name);
	}

	@Override
	public List<ProjectBasicVO> projList() {
		return sqlSession.selectList(SelectProj);
	}

}
