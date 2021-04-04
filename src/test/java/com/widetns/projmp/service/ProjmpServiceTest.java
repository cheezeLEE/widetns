package com.widetns.projmp.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.widetns.projmp.dao.ProjmpDAO;
import com.widetns.projmp.domain.TestVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class ProjmpServiceTest {

	@Autowired
	private ProjmpService service;
	
	private TestVO vo;
	
//	@Before
//	public void init() {
//		vo = new TestVO();
//		vo.setKor_name("홍길동");
//		vo.setPrj_name("프로젝트3");
//
//	}
//	
//	@Test
//	public void testProjList() {
//		log.info("kor_name : "+vo.getKor_name()+"prj_name : "+vo.getPrj_name());
//		service.projList(vo);		
//	}

}
