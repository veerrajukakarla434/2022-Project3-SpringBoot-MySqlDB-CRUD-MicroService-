package com.vkakarla.grouph.transform;

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

}
