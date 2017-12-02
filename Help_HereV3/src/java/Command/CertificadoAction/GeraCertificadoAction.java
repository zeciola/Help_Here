/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.CertificadoAction;

import Command.ICommand;
import Model.Usuario;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Date;
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
public class GeraCertificadoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        final DateFormat df = new SimpleDateFormat("ssmmHHddMMyyyy");
        final Calendar cal = Calendar.getInstance();    
        
        HttpSession sessaoUsuario = ((HttpServletRequest) request).getSession();
        Usuario user = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");
        String nomeev = request.getParameter("nome");
        String ini = request.getParameter("inicio");
        String fim = request.getParameter("fim");
        String nome = df.format(cal.getTime())+user.getPe().getSobrenome()+user.getId()+".pdf";
        
        Document doc = null;
        OutputStream os = null;
        
        try {
            //cria o documento tamanho A4, margens de 2,54c
            doc = new Document(PageSize.A4.rotate(), 72, 72, 72, 72);
            //cria a stream de saída
            os = new FileOutputStream("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/pdf/"+nome);
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
            //abre o documento
            doc.open();

            Image img = Image.getInstance("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/img/imglogo.jpg");
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);

            //adiciona o texto ao PDF 
            Font f = new Font(Font.FontFamily.COURIER, 45, Font.BOLDITALIC);
            Paragraph p1 = new Paragraph("Certificado", f);
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.setSpacingAfter(20);
            doc.add(p1);

            Paragraph p2 = new Paragraph("Certificamos para os devidos fins que "+user.getPe().getNome()+" "+user.getPe().getSobrenome()+
                    " esteve presente no evento "+nomeev+" como voluntario tendo seu inicio em "+ini+" ate "+fim);
            doc.add(p2);

            Paragraph p3 = new Paragraph(" ");
            doc.add(p3);
            doc.add(p3);
            doc.add(p3);
                        
            Paragraph p4 = new Paragraph("_____________________");
            p4.setAlignment(Element.ALIGN_CENTER);
            doc.add(p4);
            
            Paragraph p5 = new Paragraph("Diretor Operacional");
            p5.setAlignment(Element.ALIGN_CENTER);
            doc.add(p5);
            Paragraph p6 = new Paragraph("Antonio Claudio Silva");
            p6.setAlignment(Element.ALIGN_CENTER);
            doc.add(p6);
            
            
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
        sessaoUsuario.setAttribute("nomepdf", nome);
        return "acessologado/Certificados.jsp";
    }
}
