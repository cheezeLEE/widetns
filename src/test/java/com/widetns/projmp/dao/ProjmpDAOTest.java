package com.widetns.projmp.dao;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class ProjmpDAOTest {

	@Autowired
	private ProjmpDAO dao;
	
	@Before
	public void testInsertEmp() throws Exception{

		EmployeeVO vo = new EmployeeVO();
		vo.setKor_name("홍길동");
		vo.setEng_name("Hong GilDong");
		vo.setAddr1("123-456");
		vo.setAddr2("서울 금천구 가산동");
		vo.setAddr3("대륭테크노타운");
		vo.setPos("사원");
		vo.setDept("개발부");
		vo.setCareer("1년");
		vo.setEmp_level("초급");
		vo.setJoin_date(Calendar.getInstance().getTime());
		vo.setCert("정보처리기사");
		vo.setPhoto("");
		vo.setReg_writer("홍길동");
		
//		EmployeeTechVO tvo = new EmployeeTechVO();
//		tvo.setTech_code("JAVA");
//		tvo.setTech_level("하");
//		tvo.setReg_writer("홍길동");
//		
//		vo.setTechList(tvo);
		
		dao.insertEmp(vo);
	}
	
	@Test
	public void testSelectEmp() throws Exception{
		EmployeeVO vo = dao.selectEmp(1);
		log.info(vo.getEmp_num()+"/"+vo.getKor_name()+"/"+vo.getPos());
	}

}
