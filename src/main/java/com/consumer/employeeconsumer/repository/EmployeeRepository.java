package com.consumer.employeeconsumer.repository;

import com.consumer.employeeconsumer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
