package com.consumer.employeeconsumer.processor;

import com.consumer.employeeconsumer.proto.Employee;
import com.consumer.employeeconsumer.service.EmployeeService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements Processor {

    @Autowired
    EmployeeService employeeService;

    @Override
    public void process(Exchange exchange) throws Exception {

        Employee employee = exchange.getIn().getBody(Employee.class);

        String operation = employee.getOperation();

        if ("Insert".equalsIgnoreCase(operation)) {

            System.out.println("Processing employee insert: " + employee);
            employeeService.saveEmployee(employee);
        } else if ("Delete".equalsIgnoreCase(operation)) {

            System.out.println("Processing employee delete: " + employee);
            if(!employeeService.employeeExists(employee.getId())){
                throw new Exception("Employee with ID " + employee.getId() + " does not exist");
            }
            employeeService.deleteEmployeeById(employee.getId());
        } else {

            System.out.println("Unsupported operation: " + operation);
        }


    }
}
