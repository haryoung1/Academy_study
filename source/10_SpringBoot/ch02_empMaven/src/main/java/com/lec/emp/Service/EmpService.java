package com.lec.emp.Service;

import java.util.List;

import com.lec.emp.model.Dept;
import com.lec.emp.model.Emp;

public interface EmpService {
	public List<Dept> deptList();

	public List<Emp> empList(Emp emp);
}
