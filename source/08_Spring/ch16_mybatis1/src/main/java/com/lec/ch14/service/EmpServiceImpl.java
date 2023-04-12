package com.lec.ch14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch14.dao.DeptDao;
import com.lec.ch14.dao.EmpDao;
import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao eDao; // Empdao 객체를 가져와 사용한다 ?
	@Autowired
	private DeptDao dDao;

	@Override
	public List<Dept> deptlist() {
		return dDao.deptlist();
	}

	@Override
	public List<Emp> emplist(Emp schEmp) {
		// schEmp.ename = s / schEmp.job = e (소문자로 검색하면 대문자로 바꿔야함)
		if (schEmp.getEname() != null) {
			schEmp.setEname(schEmp.getEname().toUpperCase());
		}
		if (schEmp.getJob() != null) {
			schEmp.setJob(schEmp.getJob().toUpperCase());
		}
		return eDao.emplist(schEmp);
	}

}
