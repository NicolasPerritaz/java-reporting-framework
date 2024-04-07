package org.javareporting.framework.core.test.jexl;

import com.lowagie.text.pdf.PdfWriter;
import org.apache.commons.jexl3.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class JexlTest {

    @Test
    void testJexlParse() {


        final JexlEngine jexl = new JexlBuilder().create();
        JexlContext context = new MapContext();
        context.set("currentTime", "${18 * 2}");

        JexlExpression currentTimeExpression = jexl.createExpression("currentTime");

        System.out.println(currentTimeExpression.evaluate(context));

    }

}
