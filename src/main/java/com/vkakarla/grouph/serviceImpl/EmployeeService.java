package com.vkakarla.grouph.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.grouph.dto.EmployeeDto;
import com.vkakarla.grouph.entities.Employee;
import com.vkakarla.grouph.repo.EmployeeRepository;
import com.vkakarla.grouph.service.IEmployeeService;
import com.vkakarla.grouph.transform.EmployeeHelpher;


@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeHelpher helpher;

	@Override
	public void createEmployee(EmployeeDto dto) {
		
		Employee entity = helpher.prepareEmployeeData(dto);
		
		employeeRepository.save(entity);
	}
    
	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(long id) {
		Employee employee = null;
		employee = employeeRepository.getOne(id);

		EmployeeDto dto = helpher.prepareEmployeeResponse(employee);
		System.out.println(dto);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {

		employeeRepository.save(employee);
	}
    
	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.deleteById(id);
	}

}
