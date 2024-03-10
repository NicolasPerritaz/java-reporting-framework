package org.javareporting.framework.core.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import org.javareporting.framework.core.generator.ReportGenerator;
import org.javareporting.framework.core.model.Report;
import org.javareporting.framework.core.model.TextItem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfGenerator implements ReportGenerator {
    @Override
    public void generateReport(Report report) {

        try (OutputStream os = new FileOutputStream("out.pdf");
             Document document = new Document()) {
            PdfWriter instance = PdfWriter.getInstance(document, os);
            document.open();
            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));
            report.reportItems().stream()
                    .filter(TextItem.class::isInstance)
                    .map(TextItem.class::cast)
                    .forEach(ti -> document.add(new Paragraph(ti.text())));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to generate report", e);
        }

    }
}
