/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.ContribuirAction;

import Command.ICommand;
import DAO.DAOContribuir;
import Model.Contribuicao;
import Model.Evento;
import Model.Usuario;
import Util.GeraNumero;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class Doar2Condicional implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sessaoUsuario = ((HttpServletRequest) request).getSession();
        String numero;
        Document doc = null;
        OutputStream os = null;
        try {

            Usuario u = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");
            Evento e = (Evento) sessaoUsuario.getAttribute("evento");

            String valorString = request.getParameter("valor");
            Double valor = Double.parseDouble(request.getParameter("valor"));
            final DateFormat df = new SimpleDateFormat("ddMMyyyy");
            final Calendar cal = Calendar.getInstance();

            //Recupera Ultimo gerado
            DAOContribuir daoc = new DAOContribuir();
            String valorAntes = daoc.RecuperaUltimoValor();

            //Consegue novo numero
            GeraNumero gera = new GeraNumero();
            numero = gera.GeraNumero(valorAntes);

            Contribuicao c = new Contribuicao();
            c.setNumeroBoleto(numero);

            c.setValor(valor);

            //cria o documento tamanho A4, margens de 2,54c
            doc = new Document(PageSize.A4, 52, 52, 52, 52);
            //stream de saída
            os = new FileOutputStream("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/pdf/" + numero + ".pdf");
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
            //abre o documento
            doc.open();

            //adiciona o texto ao PDF 
            Font f = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);

            //atualiza ultimo numero gerado
            daoc.AtualizaUltimoValor(c);

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

            c.setUser(u);
            c.setEv(e);
            c.setNumeroBoleto(numero);

            //REALIZAR DOAÇÃO     
            daoc.DoarValor(c);
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
        sessaoUsuario.setAttribute("nomepdf", numero+".pdf");
        return "acessologado/boleto.jsp";
    }
}
