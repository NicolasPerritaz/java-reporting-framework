package org.javareporting.framework.core.generator;

import org.javareporting.framework.core.model.ReportModel;

public interface ReportGenerator {

    void generateReport(ReportModel reportModel);
}
