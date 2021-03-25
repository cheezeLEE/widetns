package com.widetns.projmp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommonCodeVO {
	private String main_cate, sub_cate, code_name;
	
	private Date reg_date, mod_date;
	private String reg_writer, mod_writer;
	private char deleted_yn;
}
