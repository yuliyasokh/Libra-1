package com.netcracker.libra.util.pdf;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.xhtmlrenderer.pdf.ITextRenderer;


/**
 *
 * @author MorrDeck
 */
public class PDFCreator {
    private static ServletContext servletContext;

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public  void setServletContext(ServletContext servletContext) {
        PDFCreator.servletContext = servletContext;
    }

    public  void createFormPDF(int id, String url) {
        try {
            String outputFile = servletContext.getRealPath("WEB-INF/forms/form"+id+".pdf"); 
            OutputStream os = new FileOutputStream(outputFile);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(new FileOutputStream(outputFile));
        } catch (DocumentException ex) {
        } catch (IOException ex) {
        }
    }
}
