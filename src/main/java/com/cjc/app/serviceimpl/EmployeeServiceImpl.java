package com.cjc.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.model.Employee;
import com.cjc.app.repository.EmployeeRepository;
import com.cjc.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		System.out.println("In Service Layer :" + employee);
		Employee dbemployee = employeeRepository.save(employee);
		return dbemployee;
	}

	@Override
	public Employee getEmployee(int id) {

		if (employeeRepository.existsById(id)) {
			Employee dbEmployee = employeeRepository.findById(id).get();
			return dbEmployee;
		}

		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public String deleteEmployee(int id) {

		String msg = "";

		if (employeeRepository.existsById(id)) {

			employeeRepository.deleteById(id);
			msg = "Record Deleted successfully for given Id :" + id;
			return msg;
		}
		msg = "Employee is not found for given Id :" + id;
		return msg;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {

		if (employeeRepository.existsById(id)) {
			Employee dbemployee = employeeRepository.findById(id).get();

			dbemployee.setName(employee.getName());
			dbemployee.setAddress(employee.getAddress());
			dbemployee.setDesignation(employee.getDesignation());
			dbemployee.setSalary(employee.getSalary());
			Employee updatedEmployee = employeeRepository.save(dbemployee);
			return updatedEmployee;
		}

		return null;
	}

	@Override
	public Employee editEmployee(int id, Employee employee) {

		if (employeeRepository.existsById(id)) {
			Employee dbEmployee = employeeRepository.findById(id).get();

			if (employee.getName() != null) {
				dbEmployee.setName(employee.getName());
			}

			if (employee.getAddress() != null) {
				dbEmployee.setAddress(employee.getAddress());
			}

			if (employee.getDesignation() != null) {
				dbEmployee.setDesignation(employee.getDesignation());
			}

			if (employee.getSalary() != null) {
				dbEmployee.setSalary(employee.getSalary());
			}

			Employee editedEmployee = employeeRepository.save(dbEmployee);
			return editedEmployee;

		}
		return null;
	}

}
