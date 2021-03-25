package com.widetns.projmp.dao;

public interface ProjmpDAO {
	public String getTime();
	public void insertEmp(EmployeeVO vo);
	public EmployeeVO selectEmp(int emp_num);
}
