package com.vkakarla.grouph.service;

import java.util.List;

import com.vkakarla.grouph.dto.EmployeeDto;

public interface IEmployeeService {

	
	public void createEmployee(EmployeeDto dto);

	public EmployeeDto getEmployeeById(long id);

	public EmployeeDto updateEmployee(long employeeId, EmployeeDto dto);

	public void deleteEmployee(long id);

	public List<EmployeeDto> getAllEmployees();
}
