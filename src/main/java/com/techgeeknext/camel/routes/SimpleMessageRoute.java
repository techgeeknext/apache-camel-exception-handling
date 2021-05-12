package com.techgeeknext.camel.routes;

import com.techgeeknext.camel.custom.exceptions.GenericCamelCustomException;
import com.techgeeknext.camel.custom.exceptions.ProcessorCustomException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(GenericCamelCustomException.class).process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("Handled exception using onException block.");
            }
        }).log("${body}").handled(true);


        //generates an event/constant message every 60 seconds
        from("timer:active-mq-timer?period=60000")
                .transform().constant("Hello Message from Apache Camel Route1 - TechGeekNext")
                .log("${body}")
                //throw custom exception
                .process(new ProcessorCustomException());

        //generates an event/constant message every 60 seconds
        from("timer:active-mq-timer?period=60000")
                .transform().constant("Hello Message from Apache Camel Route2 - TechGeekNext")
                .log("${body}")
                //throw custom exception
                .process(new ProcessorCustomException());
    }
}