package com.vkakarla.grouph.serviceImpl;

import java.util.List;

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
		System.out.println("******* Inserted Employee Employees");
	}

	@SuppressWarnings("deprecation")
	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee = null;
		employee = employeeRepository.getOne(id);
		EmployeeDto dto = helpher.prepareEmployeeResponse(employee);
		return dto;
	}

	

	@Override
	public EmployeeDto updateEmployee(long employeeId, EmployeeDto dto) {
		
		Employee employee = employeeRepository.findById(employeeId).get();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setDepartment(dto.getDepartment());
		employee.setEmail(dto.getEmail());
		employee.setAddress(dto.getAddress());
		Employee upDatedemployeeObj = employeeRepository.save(employee);
		
		EmployeeDto employeeDto = helpher.prepareEmployeeResponse(upDatedemployeeObj);
		
		return employeeDto;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {

		List<Employee> list = employeeRepository.findAll();
		 List<EmployeeDto> dtoList = helpher.maptoEmployeeDtoList(list);
		 
		 System.out.println("******* Retreved All Employees");
		return dtoList;
	}

}
