package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeesRepository) {
		super();
		this.employeeRepository  = employeesRepository;
	}

	@Override
	public Employee saveEmployee(Employee employees) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employees);
	}

	@Override
	public List<Employee> listAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		/* 
		 * Optional<Employee> employee = employeeRepository.findById(Id);
		 * if(employee.isPresent()) { return employee.get(); }else { throw new
		 * ResourceNotFoundException("Employee", "Id", Id); }
		 */
		
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		// TODO Auto-generated method stub
		Employee existedEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		System.out.println("000000000 existedEmployee:"+existedEmployee);
		System.out.println("000000000 check existedEmployee:"+(existedEmployee != null));
		if(existedEmployee != null) {
			existedEmployee.setFirstName(employee.getFirstName());
			existedEmployee.setLastName(employee.getLastName());
			existedEmployee.setEmail(employee.getEmail());
			employeeRepository.save(existedEmployee);
		}
		return existedEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
