package com.example.employeemanager.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
	private final EmployeeService employeeService;

	public EmployeeResouce(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
	    List<Employee> employees = employeeService.findAllEmployees();
	    try {
	        return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("MEsaj: "+e.getMessage()+" ---------------------------------- "+e.getStackTrace());
            return null;
        } 
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee  updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>( updateEmployee, HttpStatus.OK);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
