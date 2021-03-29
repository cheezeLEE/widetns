package com.widetns.projmp.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.widetns.projmp.domain.TestVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class ProjmpDAOTest {

	@Autowired
	private ProjmpDAO dao;
	
	TestVO vo = new TestVO();
	
//	@Test
//	public void testSelectEmp() throws Exception{
//		EmployeeVO vo = dao.selectEmp("이나나");
//		log.info(vo.getEmp_num()+"/"+vo.getKor_name()+"/"+vo.getPos());
//	}
	
	@Before
	public void initialize() {
		vo = new TestVO();
		vo.setKor_name("홍길동");
		vo.setPrj_name("프로젝트3");
	}
	
	
	@Test
	public void testSelectProj() throws Exception{
		dao.projList(vo).forEach(proj->log.info(proj));
	}
}