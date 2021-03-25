package com.widetns.projmp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeTechVO {
	private int emp_num;
	private String tech_code, tech_level;
	
	private Date reg_date, mod_date;
	private String reg_writer, mod_writer;
	private char deleted_yn;

}
