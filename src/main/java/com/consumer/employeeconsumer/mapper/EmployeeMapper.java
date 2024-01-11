package com.consumer.employeeconsumer.mapper;

import com.consumer.employeeconsumer.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee mapToEmployeeEntity(com.consumer.employeeconsumer.proto.Employee employee){



        Employee employee1 = new Employee();

        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        employee1.setDesignation(employee.getDesignation());
        employee1.setGender(employee.getGender());

        return employee1;

    }


}
