package com.widetns.projmp.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjmpDAOImplTest {

	@Autowired
	private ProjmpDAO dao;
	
	@Test
	public void testGetTime() {
		dao.getTime();
	}

}
