package org.javareporting.client.sb;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ReportingClientTestConfiguration {

    @Bean
    public TestBean testBean() {
        return  new TestBean("TEST BEAN");
    }

    public static class TestBean {

        private final String value;

        TestBean(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
