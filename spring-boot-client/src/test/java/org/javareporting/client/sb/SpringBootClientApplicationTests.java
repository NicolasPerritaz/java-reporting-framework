package org.javareporting.client.sb;

import org.javareporting.client.sb.configuration.SpringELDataEvaluator;
import org.javareporting.framework.core.engine.ReportEngine;
import org.javareporting.framework.core.engine.configuration.ReportEngineConfiguration;
import org.javareporting.framework.core.model.Data;
import org.javareporting.framework.core.model.ReportModel;
import org.javareporting.framework.core.model.instance.ReportInstance;
import org.javareporting.framework.core.model.instance.TextInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(ReportingClientTestConfiguration.class)
class SpringBootClientApplicationTests {

	@Autowired
	ReportingClientTestConfiguration.TestBean testBean;

	@Autowired
	SpringELDataEvaluator springELDataEvaluator;

	@Test
	void contextLoads() {
		ReportEngineConfiguration reportEngineConfiguration = new ReportEngineConfiguration.Builder()
				.dataEvaluator(springELDataEvaluator)
				.build();

		ReportEngine reportEngine = new ReportEngine(reportEngineConfiguration);
		ReportModel reportModel = new ReportModel(List.of(new Data("#{testBean.getValue()}")));
		ReportInstance reportInstance = reportEngine.build(reportModel);
		assertThat(reportInstance.reportItemInstances().get(0)).isEqualTo(new TextInstance("TEST BEAN"));


	}

}
