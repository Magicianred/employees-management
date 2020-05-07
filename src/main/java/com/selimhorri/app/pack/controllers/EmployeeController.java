package com.selimhorri.app.pack.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selimhorri.app.pack.models.entities.Employee;
import com.selimhorri.app.pack.services.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping({"/api/employees", "/api/employee"})
public class EmployeeController {
	
	private final EmployeeService service;
	
	@Autowired
	public EmployeeController(final EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/all"})
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}", "/get/{id}"})
	public ResponseEntity<Employee> findById(@PathVariable("id") final Integer id) {
		
		if (id == null)
			throw new NullPointerException("------------ Missed arg(s) in URL : employee_id ------------");
		
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Employee> save(@RequestBody @Valid final Employee employee, final BindingResult buiBindingResult) {
		
		// for now .....
		if (buiBindingResult.hasErrors()) {
			return null;
		}
		
		if (employee == null)
			throw new NullPointerException("------------ Missed arg(s) in URL : employee ------------");
		
		return new ResponseEntity<>(this.service.save(employee), HttpStatus.OK);
	}
	
	@PutMapping(value = {"/{id}", "/update/{id}"})
	public ResponseEntity<Employee> updateById(@PathVariable("id") final Integer id) {
		return null;
	}
	
	@DeleteMapping(value = {"/{id}", "/delete/{id}"})
	public void deleteById(@PathVariable("id") final Integer id) {

		if (id == null)
			throw new NullPointerException("------------ Missed arg(s) in URL : employee_id ------------");
		
		this.service.deleteById(id);
	}
	
	
	
}










