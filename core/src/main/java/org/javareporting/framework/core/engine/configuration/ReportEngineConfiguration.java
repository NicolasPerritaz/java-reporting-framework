package org.javareporting.framework.core.engine.configuration;

import org.javareporting.framework.core.engine.DataEvaluator;

public class ReportEngineConfiguration {

    private DataEvaluator dataEvaluator;

    ReportEngineConfiguration(DataEvaluator dataEvaluator) {
        this.dataEvaluator = dataEvaluator;
    }

    public DataEvaluator getDataEvaluator() {
        return dataEvaluator;
    }

    public static class Builder {
        private DataEvaluator dataEvaluator;

        public Builder dataEvaluator(DataEvaluator dataEvaluator) {
            this.dataEvaluator = dataEvaluator;
            return this;
        }

        public ReportEngineConfiguration build() {
            return new ReportEngineConfiguration(dataEvaluator);
        }
    }

}
