package org.javareporting.framework.core;

import org.javareporting.framework.core.engine.ReportEngine;
import org.javareporting.framework.core.model.Data;
import org.javareporting.framework.core.model.ReportModel;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReportGenerationTest {

    @Test
    void generateReport() {
        ReportModel reportModel = new ReportModel(List.of(new Data("${testDataSet.helloNow}")));

        ReportEngine engine = new ReportEngine() ;
        engine.render(reportModel);

    }

}
