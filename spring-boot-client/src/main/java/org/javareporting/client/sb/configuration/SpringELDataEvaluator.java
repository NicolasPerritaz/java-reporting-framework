package org.javareporting.client.sb.configuration;

import org.javareporting.framework.core.engine.DataEvaluator;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpringELDataEvaluator implements DataEvaluator {

    private final ExpressionParser expressionParser;
    private final EvaluationContext evaluationContext;

    public SpringELDataEvaluator() {
        expressionParser = new SpelExpressionParser();
        evaluationContext = new StandardEvaluationContext();
    }

    @Override
    public String evaluate(String expression) {

        Expression expr = expressionParser.parseExpression(expression);
        return String.valueOf(expr.getValue(evaluationContext));
    }
}
