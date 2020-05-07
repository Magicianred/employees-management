package com.selimhorri.app.pack.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.selimhorri.app.pack.models.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(name = "Set.getManagers", nativeQuery = true)
	public abstract Set<Employee> getManagers();
	
}








