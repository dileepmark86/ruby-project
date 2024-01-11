package com.consumer.employeeconsumer.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmployeeRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:myTopic")
                .process();
    }
}
