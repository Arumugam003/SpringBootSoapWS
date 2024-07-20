package com.volley.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.volley.model.Employee;
import com.volley.service.EmployeeService;

import allapis.volley.com.AddEmployeeRequest;
import allapis.volley.com.AddEmployeeResponse;
import allapis.volley.com.DeleteEmployeeRequest;
import allapis.volley.com.DeleteEmployeeResponse;
import allapis.volley.com.EmployeeInfo;
import allapis.volley.com.GetEmployeeByIdRequest;
import allapis.volley.com.GetEmployeeResponse;
import allapis.volley.com.ServiceStatus;
import allapis.volley.com.UpdateEmployeeRequest;
import allapis.volley.com.UpdateEmployeeResponse;

@Endpoint
public class EmployeeEndPoint {
	
	 private static final String NAMESPACE_URI = "http://com.volley.allapis";
	 
	 	@Autowired
	    private EmployeeService employeeService;

	  
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	    @ResponsePayload
	    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
	    	
	    	AddEmployeeResponse response = new AddEmployeeResponse();
	    	ServiceStatus serviceStatus = new ServiceStatus();
	        Employee employee = new Employee();
	    	
	    	BeanUtils.copyProperties(request.getEmployeeInfo(),employee);
	    	employeeService.AddEmployee(employee);
	    	serviceStatus.setStatus("SUCCESS");
	    	serviceStatus.setMessage("Added successfully");
	        response.setServiceStatus(serviceStatus);

	        return response;
	    }
	    

	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	    @ResponsePayload
	    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
	    	
	    	GetEmployeeResponse response = new GetEmployeeResponse();
	        EmployeeInfo employeeInfo = new EmployeeInfo();
	    	BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()),employeeInfo);
	        response.setEmployeeInfo(employeeInfo);

	        return response;
	    }
	    
	    
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	    @ResponsePayload
	    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
	    	
	    	UpdateEmployeeResponse response = new UpdateEmployeeResponse();
	    	ServiceStatus serviceStatus = new ServiceStatus();
	        Employee employee = new Employee();
	    	
	    	BeanUtils.copyProperties(request.getEmployeeInfo(),employee);
	    	employeeService.updateEmployee(employee);
	    	serviceStatus.setStatus("SUCCESS");
	    	serviceStatus.setMessage("Updated successfully");
	        response.setServiceStatus(serviceStatus);

	        return response;
	    }
	    
	    
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	    @ResponsePayload
	    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
	    	
	    	DeleteEmployeeResponse response = new DeleteEmployeeResponse();
	    	ServiceStatus serviceStatus = new ServiceStatus();
	   
	        employeeService.deleteEmployee(request.getEmployeeId());
	        serviceStatus.setStatus("SUCCESS");
	    	serviceStatus.setMessage("Deleted successfully");
	        response.setServiceStatus(serviceStatus);

	        return response;
	    }

}
