package com.netcracker.libra.util.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.HtmlNode;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.SimpleHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.TagNodeVisitor;
import org.htmlcleaner.Utils;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
 
public class PDFCreatorTest {
 
    public void createPDF(String pdfFilename, String url) {
        PdfWriter pdfWriter = null;
        Document document = new Document();
 
        try {
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(pdfFilename));
            document.addCreationDate();
            document.setPageSize(PageSize.LETTER);
            document.open();
            String html = cleanProps(url);
            System.out.println(html);
            Reader sr = new StringReader(html);
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, sr);
            document.close();
            pdfWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
 
    }
 
    public String cleanHtml(final String url) throws MalformedURLException, IOException {
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(new URL(url));
        // traverse whole DOM and update images to absolute URLs
        node.traverse(new TagNodeVisitor() {
            public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
                if (htmlNode instanceof TagNode) {
                    TagNode tag = (TagNode) htmlNode;
                    String tagName = tag.getName();
                    if ("img".equals(tagName)) {
                        String src = tag.getAttributeByName("src");
                        if (src != null) {
                            tag.setAttribute("src", Utils.fullUrl(url, src));
                        }
                    }
                }
                return true;
            }
        });
 
        SimpleHtmlSerializer serializer = new SimpleHtmlSerializer(cleaner.getProperties());
        StringWriter sw = new StringWriter();
        serializer.write(node, sw, "UTF-8");
        return sw.toString();
    }
 
    public String cleanProps(final String url) {
        CleanerProperties props = new CleanerProperties();
        props.setTranslateSpecialEntities(true);
        props.setTransResCharsToNCR(true);
        props.setOmitComments(true);
        TagNode tagNode = null;
        try {
            tagNode = new HtmlCleaner(props).clean(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringWriter sw = new StringWriter();
        try {
            new PrettyXmlSerializer(props).write(tagNode, sw, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
 
//    static class Test {
//        public static void main(String[] args) throws FileNotFoundException, DocumentException {
//            String url = "http://localhost:8091/Libra/showAdvertise.html";
//            String pdfFile = "tst.pdf";
//            PDFCreatorTest pdf = new PDFCreatorTest();
//            pdf.createPDF(pdfFile, url);
//        }
//    }
}
