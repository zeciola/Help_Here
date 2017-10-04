package Control;

import DAO.DAOContribuir;
import Model.Contribuicao;
import Model.Evento;
import Model.Instituicao;
import Model.Usuario;
import Util.GeraNumero;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        Document doc = null;
        OutputStream os = null;
        try {
            String valorString = request.getParameter("valor");
            Double valor = Double.parseDouble(request.getParameter("valor"));
            final DateFormat df = new SimpleDateFormat("ddMMyyyy");
            final Calendar cal = Calendar.getInstance();

            //cria o documento tamanho A4, margens de 2,54c
            doc = new Document(PageSize.A4, 52, 52, 52, 52);
            //stream de saída
            os = new FileOutputStream("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/pdf/MeuPrimeiroBoleto2.pdf");
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
            //abre o documento
            doc.open();

            //adiciona o texto ao PDF 
            Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);

            //Recupera Ultimo gerado
            DAOContribuir daoc = new DAOContribuir();
            String valorAntes = daoc.RecuperaUltimoValor();

            //Consegue novo numero
            GeraNumero gera = new GeraNumero();
            String numero = gera.GeraNumero(valorAntes);

            Contribuicao c = new Contribuicao();
            c.setNumeroBoleto(numero);

            c.setValor(valor);

            //atualiza ultimo numero gerado
            daoc.AtualizaUltimoValor(c);

            HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
            Usuario u =(Usuario)sessaoUsuario.getAttribute("usuarioAutenticado");
            Evento e =(Evento)sessaoUsuario.getAttribute("evento");
            
            
            //c.setDatacad();
            c.setUser(u);
            c.setEv(e);
            
            //REALIZAR DOAÇÃO     

            //

            //
            
            //daoc.DoarValor(c);
            
            //
            
            Paragraph p1 = new Paragraph(numero + "." + df.format(cal.getTime()), f);
            doc.add(p1);

            Paragraph p2 = new Paragraph("Banco Escolhido.");
            doc.add(p2);

            Paragraph p3 = new Paragraph(numero);
            doc.add(p3);

            PdfPTable table = new PdfPTable(5);
            PdfPCell header = new PdfPCell(new Paragraph("Dados"));
            header.setColspan(5);
            table.addCell(header);
            table.addCell("Local Pagamento");
            table.addCell("Vencimento");
            table.addCell("Beneficiario");
            table.addCell("Data Processamento");
            table.addCell("Valor");
            table.addCell("redeBancaria");
            table.addCell("25/09/2017");
            table.addCell("HelpHere");
            table.addCell("Hoje");
            table.addCell(valorString);
            doc.add(table);
            doc.add(p1);
            doc.add(table);

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
