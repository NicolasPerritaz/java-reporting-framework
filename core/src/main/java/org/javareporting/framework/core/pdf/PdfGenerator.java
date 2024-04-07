package org.javareporting.framework.core.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import org.javareporting.framework.core.generator.ReportGenerator;
import org.javareporting.framework.core.model.Data;
import org.javareporting.framework.core.model.ReportModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfGenerator implements ReportGenerator {
    @Override
    public void generateReport(ReportModel reportModel) {

        try (OutputStream os = new FileOutputStream("out.pdf");
             Document document = new Document()) {
            PdfWriter instance = PdfWriter.getInstance(document, os);
            document.open();
            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));
            reportModel.reportItems().stream()
                    .filter(Data.class::isInstance)
                    .map(Data.class::cast)
                    .forEach(d -> document.add(new Paragraph(d.expression())));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to generate report", e);
        }

    }
}
