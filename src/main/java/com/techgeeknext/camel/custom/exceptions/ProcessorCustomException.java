package com.techgeeknext.camel.custom.exceptions;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorCustomException implements Processor{

    public void process(Exchange exchange) throws Exception {
        System.out.println("Custom Exception from ProcessorCustomException.");
        throw new GenericCamelCustomException("Custom Exception from ProcessorCustomException.");
    }
}
