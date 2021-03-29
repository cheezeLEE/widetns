package com.widetns.projmp.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProjectMappingVO {
//	private int emp_num, prj_num;
	private Date start_date, end_date;
	private String role, task;
	
	private Date reg_date, mod_date;
	private String reg_writer, mod_writer;
	private char deleted_yn;
	
	private List<EmployeeVO> employee;
	private List<ProjectBasicVO> projBasic;
}
