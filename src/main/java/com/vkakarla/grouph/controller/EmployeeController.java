package com.vkakarla.grouph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vkakarla.grouph.dto.EmployeeDto;
import com.vkakarla.grouph.entities.Employee;
import com.vkakarla.grouph.service.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class EmployeeController {

    @Autowired
	IEmployeeService employeeService; 
	
    @Operation(summary = "Save Employee", description = "Save Employee into DataBases")
	@PostMapping(value = "/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDto dto) {

		employeeService.createEmployee(dto);
		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.CREATED);
	}

    @Operation(summary = "Get Employees", description = "Get Employee From DataBases")
	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable Long id) {

		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}

    @Operation(summary = "Update Employees", description = "Update Employee into DataBases")
	@PutMapping(value = "/employee")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {

		employeeService.updateEmployee(employee);
		return new ResponseEntity<Object>("Successfully Updated", HttpStatus.OK);
	}

    @Operation(summary = "Delete Employees", description = "Delete Employee From DataBases")
	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.NO_CONTENT);
	}

}
