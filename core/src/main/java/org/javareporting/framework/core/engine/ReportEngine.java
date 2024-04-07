package org.javareporting.framework.core.engine;

import org.javareporting.framework.core.engine.configuration.ReportEngineConfiguration;
import org.javareporting.framework.core.generator.ReportGenerator;
import org.javareporting.framework.core.model.ReportModel;
import org.javareporting.framework.core.model.instance.ReportInstance;
import org.javareporting.framework.core.pdf.PdfGenerator;

import java.util.Optional;

public class ReportEngine {

    private final ReportBuilder reportBuilder;


    public ReportEngine(ReportEngineConfiguration reportEngineConfiguration) {
        this.reportBuilder = new ReportBuilder(Optional.ofNullable(reportEngineConfiguration.getDataEvaluator()).orElse(expr -> expr));
    }

    public ReportInstance build(ReportModel reportModel) {
        return reportBuilder.build(reportModel);
    }


    public void render(ReportModel reportModel) {

        ReportGenerator generator = new PdfGenerator();
        generator.generateReport(reportModel);
    }
}
