package org.javareporting.framework.core.test;

import org.javareporting.framework.core.annotation.Data;
import org.javareporting.framework.core.annotation.DataSet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DataSet("testDataSet")
public class TestDataSet {

    @Data
    public String helloNow() {
        return "Hello World. It is " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " here";
    }
}
