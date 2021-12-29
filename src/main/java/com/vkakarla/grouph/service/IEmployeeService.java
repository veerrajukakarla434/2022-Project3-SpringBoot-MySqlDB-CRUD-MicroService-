package com.vkakarla.grouph.service;

import com.vkakarla.grouph.dto.EmployeeDto;
import com.vkakarla.grouph.entities.Employee;

public interface IEmployeeService {

	
	public void createEmployee(EmployeeDto dto);

	public Employee getEmployeeById(long id);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(long id);


}
