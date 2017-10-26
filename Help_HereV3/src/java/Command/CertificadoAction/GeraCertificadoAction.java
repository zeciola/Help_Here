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
        
        String nome = "pdf7.pdf";
        HttpSession sessaoUsuario = ((HttpServletRequest) request).getSession();
        Usuario user = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");

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

            Image img = Image.getInstance("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/defaut.jpg");
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);

            //adiciona o texto ao PDF 
            Font f = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
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
        sessaoUsuario.setAttribute("nomepdf", nome);
        return "teste.jsp";
    }
}
