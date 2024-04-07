package org.javareporting.framework.core.engine;

import org.javareporting.framework.core.model.Data;
import org.javareporting.framework.core.model.ReportModel;
import org.javareporting.framework.core.model.instance.ReportInstance;
import org.javareporting.framework.core.model.instance.TextInstance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportBuilderTest {

    @Mock
    private DataEvaluator dataEvaluator;
    @Test
    void build() {
        ReportBuilder builder = new ReportBuilder(dataEvaluator);
        String expression = "Hello, today is ${currentDate}";
        String evaluated = "Hello, today is June 06, 1966";

        ReportModel reportModel = new ReportModel(List.of(new Data(expression)));

        when(dataEvaluator.evaluate(expression)).thenReturn(evaluated);

        ReportInstance reportInstance = builder.build(reportModel);

        assertThat(reportInstance).isEqualTo(new ReportInstance(List.of(new TextInstance(evaluated))));
    }
}