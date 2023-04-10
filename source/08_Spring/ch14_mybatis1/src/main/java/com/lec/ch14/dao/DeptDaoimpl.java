package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Dept;

@Repository // 이걸 선언해야 빈 생성 가능
public class DeptDaoimpl implements DeptDao {
	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public List<Dept> depList() {
		return sessionTemplate.selectList("deptlist");
	}
}