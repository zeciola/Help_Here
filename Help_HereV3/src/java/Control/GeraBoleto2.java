/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class GeraBoleto2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        Document doc = null;
            OutputStream os = null;
            try {
                //cria o documento tamanho A4, margens de 2,54c
                doc = new Document(PageSize.A4.rotate(), 72, 72, 72, 72);
                //cria a stream de saída
                os = new FileOutputStream("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/pdf/MeuPrimeiroBoleto2.pdf");
                //associa a stream de saída ao
                PdfWriter.getInstance(doc, os);
                //abre o documento
                doc.open();

                //adiciona o texto ao PDF 
                Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
                Paragraph p1 = new Paragraph("Meu primeiro arquivo PDF!", f);
                p1.setAlignment(Element.ALIGN_CENTER);
                p1.setSpacingAfter(20);
                doc.add(p1);

                Paragraph p2 = new Paragraph("Estou utilizando a classe Paragraph para criar um bloco de texto na geração do meu primeiro arquivo PDF.");
                doc.add(p2);

            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                    //fechamento da stream de saída
                    os.close();
                }
            }
            new Thread().sleep(4000);
            response.sendRedirect("teste2.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(GeraBoleto2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GeraBoleto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(GeraBoleto2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GeraBoleto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
