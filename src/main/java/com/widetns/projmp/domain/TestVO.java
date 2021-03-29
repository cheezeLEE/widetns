package com.widetns.projmp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TestVO {
	private int emp_num;
	private String kor_name;
	
	private int prj_num;
	private String prj_name, pm_name;
	private Date prj_start, prj_end;
}
