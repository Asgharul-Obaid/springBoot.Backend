package com.springboot.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.model.Employee;
import com.springboot.springboot.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//build create employee Rest API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	//build get all employee rest API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	//build get employee by id rest API
	//http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	//update employee rest api
	//http://localhost:8080/api/employees/1
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long id
			   ,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
	}
	//build delete rest api
	@DeleteMapping({"id"})
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee delete succesfully!.",HttpStatus.OK);
	}
}

