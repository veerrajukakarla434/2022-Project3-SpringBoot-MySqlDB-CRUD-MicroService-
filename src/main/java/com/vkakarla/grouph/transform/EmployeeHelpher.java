package com.vkakarla.grouph.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vkakarla.grouph.dto.EmployeeDto;
import com.vkakarla.grouph.entities.Employee;

@Component
public class EmployeeHelpher {
	
	
	public Employee prepareEmployeeData(EmployeeDto dto) {
		Employee emp = new Employee();
		//emp.setId(dto.getId());
		BeanUtils.copyProperties(dto, emp);
		return emp;
	}
	
	
	public EmployeeDto prepareEmployeeResponse(Employee emp) {
		EmployeeDto dto = new EmployeeDto();
		//emp.setId(dto.getId());
		BeanUtils.copyProperties(emp, dto);
		return dto;
	}
	
	
	public List<EmployeeDto> maptoEmployeeDtoList(List<Employee> empList){
		
		List<EmployeeDto> list = new ArrayList<>();
		
		 for(Employee emp:empList) {
			 EmployeeDto dto = prepareEmployeeResponse(emp);
			 list.add(dto);
		 }
		
		return list;
	}
	

}
