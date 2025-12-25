package com.cjc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.model.Employee;
import com.cjc.app.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// POST : http://localhost:9000/api/addEmployee

	@PostMapping(value = "/addEmployee", produces = { "application/xml", "application/json" }, consumes = {
			"application/xml", "application/json" })
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("In Controller Layer :" + employee);
		Employee dbEmployee = employeeService.saveEmployee(employee);
		return dbEmployee;
	}

	// Path parameters
	// GET : http://localhost:9000/api/getEmployee/2
	@GetMapping(value = "/getEmployee/{id}", produces = { "application/xml", "application/json" })
	public Employee getEmployee(@PathVariable("id") int id) {

		System.out.println("fetching data for Employee Id : " + id);
		Employee dbEmployee = employeeService.getEmployee(id);
		return dbEmployee;
	}

	// GET :http://localhost:9000/api/getEmployees

	@GetMapping(value = "/getEmployees")
	public List<Employee> getAllEmployee() {
		List<Employee> empList = employeeService.getAllEmployee();
		return empList;
	}

	// GetAll For XML

	// Path parameter
	// DELETE : http://localhost:9000/api/deleteEmployee/1

	@DeleteMapping(value = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		String msg = employeeService.deleteEmployee(id);
		return msg;
	}

	// Path Parameter
	// PUT : http://localhost:9000/api/updateEmployee
	@PutMapping(value = "/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		return updatedEmployee;
	}

	// PATCH :http://localhost:9000/api/editEmployee

	@PatchMapping(value = "/editEmployee/{id}")
	public Employee editEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee editedEmployee = employeeService.editEmployee(id, employee);
		return editedEmployee;
	}

}
