package com.lec.ch14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;
import com.lec.ch14.service.EmpService;

@Controller // 컨트롤러 어노테이션 선언 필수
public class EmpController {
	@Autowired
	private EmpService service; // 컨트롤러는 서비스를 의존

	@ModelAttribute("deptlist")
	public List<Dept> deptList() {
		return service.deptlist();
	}

	@RequestMapping(value = "emp", method = RequestMethod.GET)
	public String emp(@ModelAttribute("schEmp") Emp schEmp, Model model) {
		model.addAttribute("emplist", service.emplist(schEmp));
		return "emp";
	}
}