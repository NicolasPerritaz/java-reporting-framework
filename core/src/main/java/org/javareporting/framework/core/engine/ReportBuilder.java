package org.javareporting.framework.core.engine;

import org.javareporting.framework.core.model.Data;
import org.javareporting.framework.core.model.ReportItem;
import org.javareporting.framework.core.model.ReportModel;
import org.javareporting.framework.core.model.instance.ReportInstance;
import org.javareporting.framework.core.model.instance.ReportItemInstance;
import org.javareporting.framework.core.model.instance.TextInstance;

import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {

    private final DataEvaluator dataEvaluator;

    ReportBuilder(DataEvaluator dataEvaluator) {
        this.dataEvaluator = dataEvaluator;
    }
    public ReportInstance build(ReportModel reportModel) {
        List<ReportItemInstance> reportItemInstances = new ArrayList<>();
        for (ReportItem reportItem : reportModel.reportItems()) {
            switch (reportItem) {
                case Data data -> reportItemInstances.add(new TextInstance(dataEvaluator.evaluate(data.expression())));
            }
        }
        return new ReportInstance(reportItemInstances);

    }
}
