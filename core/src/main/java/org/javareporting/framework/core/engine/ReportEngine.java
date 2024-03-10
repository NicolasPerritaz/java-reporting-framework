package org.javareporting.framework.core.engine;

import org.javareporting.framework.core.generator.ReportGenerator;
import org.javareporting.framework.core.model.Report;
import org.javareporting.framework.core.pdf.PdfGenerator;

public class ReportEngine {


    public void generateReport(Report report) {
        ReportGenerator generator = new PdfGenerator();
        generator.generateReport(report);
    }
}
