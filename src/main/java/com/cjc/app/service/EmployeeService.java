package com.cjc.app.service;

import java.util.List;

import com.cjc.app.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Employee getEmployee(int id);

	List<Employee> getAllEmployee();

	String deleteEmployee(int id);

	Employee updateEmployee(int id, Employee employee);

	Employee editEmployee(int id, Employee employee);

}
