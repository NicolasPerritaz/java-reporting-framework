package org.javareporting.client.sb.configuration;

import org.javareporting.framework.core.engine.DataEvaluator;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringELDataEvaluator implements DataEvaluator {

    private final BeanExpressionResolver beanExpressionResolver;

    private final BeanExpressionContext beanExpressionContext;

    public SpringELDataEvaluator(ConfigurableBeanFactory configurableBeanFactory) {
        this.beanExpressionResolver = configurableBeanFactory.getBeanExpressionResolver();
        this.beanExpressionContext = new BeanExpressionContext(configurableBeanFactory, null);
    }

    @Override
    public String evaluate(String expression) {
        return String.valueOf(beanExpressionResolver.evaluate(expression, beanExpressionContext));
    }
}
