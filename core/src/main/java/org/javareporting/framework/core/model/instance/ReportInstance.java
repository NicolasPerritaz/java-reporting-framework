package org.javareporting.framework.core.model.instance;

import java.util.List;

public record ReportInstance(List<ReportItemInstance> reportItemInstances) {

    public ReportInstance {
        reportItemInstances = List.copyOf(reportItemInstances);
    }

    @Override
    public List<ReportItemInstance> reportItemInstances() {
        return List.copyOf(reportItemInstances);
    }
}
