package org.javareporting.framework.core;

import org.javareporting.framework.core.engine.ReportEngine;
import org.javareporting.framework.core.model.Report;
import org.javareporting.framework.core.model.TextItem;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReportGenerationTest {

    @Test
    void generateReport() {
        Report report = new Report(List.of(new TextItem("Hello World!")));

        ReportEngine engine = new ReportEngine() ;
        engine.generateReport(report);

    }

}
