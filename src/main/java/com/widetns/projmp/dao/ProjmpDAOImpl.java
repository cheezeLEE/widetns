package com.widetns.projmp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjmpDAOImpl implements ProjmpDAO {

	private SqlSession sqlSession;
	
	private static String namespace = "com.widetns.projmp.dao.ProjmpDAO";
	
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

}
