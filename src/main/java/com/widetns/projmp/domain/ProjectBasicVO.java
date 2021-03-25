package com.widetns.projmp.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProjectBasicVO {
	private int prj_num;
	private String prj_name, client, manager, manager_tel, pm_name, etc;
	private Date prj_start, prj_end;
	private char end_yn;
	
	private Date reg_date, mod_date;
	private String reg_writer, mod_writer;
	private char deleted_yn;
	
	private List<ProjectDetailVO> projDetail;
}
