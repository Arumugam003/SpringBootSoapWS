package com.volley.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volley.model.Employee;
import com.volley.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

	@Override
	public void AddEmployee(Employee employee) {
		employeeRepository.save(employee);
	
	}

	

	@Override
	public Employee getEmployeeById(long employeeId) {
		
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		
		return emp.get();
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

}
