package Control;

import Util.ValidaImagem;
import java.io.*;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class uploadIMg extends HttpServlet {
    String caminho;
    String caminhoNome;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try {
            this.upload(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(50 * 1024 * 1024);
        String nome = "";
        List items = upload.parseRequest(request); // request vem na controladora

        // Processa os itens do upload
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.getFieldName().equals("arquivo")) {
                nome = item.getName();
                System.out.println(nome);
                ValidaImagem vi = new ValidaImagem();
                StringBuffer bn = new StringBuffer();
                vi.setNome(nome);
                vi.validar();
               
                if(vi.getStatus()){
                    nome = vi.getNome();
                    System.out.println(nome);
                    caminho = "C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/img/";
                    bn.append(caminho); // caminho
                    bn.append(nome);
                    File uploadedFile = new File(bn.toString());
                    item.write(uploadedFile);
                    caminhoNome=caminho+nome;
                    System.out.println(caminhoNome);
                }else{
                    ((HttpServletResponse)response).sendRedirect("erro.jsp");
                }
            }
        }
        //nome = "C:/imagens/" + nome;
        // chamada atualizar banco de acordo com chamada
        return nome;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
