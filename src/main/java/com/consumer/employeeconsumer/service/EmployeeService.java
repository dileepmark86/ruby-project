package com.consumer.employeeconsumer.service;

import com.consumer.employeeconsumer.mapper.EmployeeMapper;
import com.consumer.employeeconsumer.model.Employee;
import com.consumer.employeeconsumer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee saveEmployee(com.consumer.employeeconsumer.proto.Employee employee){

        Employee employee1 = employeeMapper.mapToEmployeeEntity(employee);
        return  employeeRepository.save(employee1);

    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){

        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(Long id){

        employeeRepository.deleteById(id);
    }

    public boolean employeeExists(long id){

        return employeeRepository.existsById(id);

    }



}
