package com.consumer.employeeconsumer.changedetection;

import com.consumer.employeeconsumer.proto.Employee;

import java.util.HashMap;
import java.util.Map;

public interface ChangeDetectionService {

    void captureChange(Employee employee, String operation);



}
