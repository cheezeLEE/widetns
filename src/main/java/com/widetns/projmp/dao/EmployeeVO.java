package com.widetns.projmp.dao;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeVO {
	private int emp_num;
	private String kor_name, eng_name, addr1, addr2, addr3, pos, dept, career, emp_level, cert, photo;
	private Date join_date;
	
	private Date reg_date, mod_date;
	private String reg_writer, mod_writer;
	private char deleted_yn;
	
	private List<EmployeeTechVO> techList;
}
