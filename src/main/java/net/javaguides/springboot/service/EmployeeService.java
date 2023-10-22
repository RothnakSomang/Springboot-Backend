package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employees);
	List<Employee> listAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee, Long id);
	void deleteEmployee(Long id);
}
