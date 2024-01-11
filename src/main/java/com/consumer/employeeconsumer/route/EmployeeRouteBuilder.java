package com.consumer.employeeconsumer.route;

import com.consumer.employeeconsumer.processor.EmployeeProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRouteBuilder extends RouteBuilder {

    @Autowired
    private EmployeeProcessor employeeProcessor;

    @Override
    public void configure() throws Exception {

        from("kafka:myTopic")
                .routeId("kafkaRoute")
                .log("${body}")
                .process(employeeProcessor)
                .log(LoggingLevel.INFO, "Processed Employee: ${body}")
                .onException(Exception.class)
                .log(LoggingLevel.ERROR, "Error processing Kafka message in route builder: ${exception.message}")
                .handled(true)
                .end();
    }
}
