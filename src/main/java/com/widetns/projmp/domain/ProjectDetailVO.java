package com.widetns.projmp.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProjectDetailVO {
	private int prj_detail_num, prj_num;
	private String main_cate, sub_cate;
	
	private Date reg_date, mod_date;
	private String reg_writer, mod_writer;
	private char deleted_yn;
	
	private List<CommonCodeVO> commonCode;
}
