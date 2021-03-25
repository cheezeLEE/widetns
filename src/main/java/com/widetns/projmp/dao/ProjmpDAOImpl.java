package com.widetns.projmp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjmpDAOImpl implements ProjmpDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String GetTime = "EmpMapper.getTime";
	private static final String InsertEmp = "EmpMapper.insertEmp";
	private static final String SelectEmp = "EmpMapper.selectEmp";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
	}

	@Override
	public void insertEmp(EmployeeVO vo) {
		sqlSession.insert(InsertEmp, vo);
	}

	@Override
	public EmployeeVO selectEmp(int emp_num) {
		return sqlSession.selectOne(SelectEmp, emp_num);
	}

}
