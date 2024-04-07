package org.javareporting.client.sb;

import org.javareporting.client.sb.configuration.SpringELDataEvaluator;
import org.javareporting.framework.core.engine.ReportEngine;
import org.javareporting.framework.core.engine.configuration.ReportEngineConfiguration;
import org.javareporting.framework.core.model.Data;
import org.javareporting.framework.core.model.ReportModel;
import org.javareporting.framework.core.model.instance.ReportInstance;
import org.javareporting.framework.core.model.instance.TextInstance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootClientApplicationTests {

	@Test
	void contextLoads() {
		ReportEngineConfiguration reportEngineConfiguration = new ReportEngineConfiguration.Builder()
				.dataEvaluator(new SpringELDataEvaluator())
				.build();

		ReportEngine reportEngine = new ReportEngine(reportEngineConfiguration);
		ReportModel reportModel = new ReportModel(List.of(new Data("2 * 7")));
		ReportInstance reportInstance = reportEngine.build(reportModel);
		assertThat(reportInstance.reportItemInstances().get(0)).isEqualTo(new TextInstance("14"));


	}

}
