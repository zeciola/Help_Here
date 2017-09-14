/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;

public class GeraBoleto extends HttpServlet {

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
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            /*
                 * INFORMANDO DADOS SOBRE O CEDENTE.
             */
            Cedente cedente = new Cedente("Help Here", "00.000.208/0001-00");

            /*
                 * INFORMANDO DADOS SOBRE O SACADO.
             */
            Sacado sacado = new Sacado("Giovanna Figueiredo de Souza", "222.222.222-22");

            // Informando o endereço do sacado.
            Endereco enderecoSac = new Endereco();
            enderecoSac.setUF(UnidadeFederativa.RN);
            enderecoSac.setLocalidade("Natal");
            enderecoSac.setCep(new CEP("59064-120"));
            enderecoSac.setBairro("Grande Centro");
            enderecoSac.setLogradouro("Rua poeta dos programas");
            enderecoSac.setNumero("1");
            sacado.addEndereco(enderecoSac);

            /*
                 * INFORMANDO DADOS SOBRE O SACADOR AVALISTA.
             */
            SacadorAvalista sacadorAvalista = new SacadorAvalista("HelpHere", "00.000.000/0001-91");

            // Informando o endereço do sacador avalista.
            Endereco enderecoSacAval = new Endereco();
            enderecoSacAval.setUF(UnidadeFederativa.SP);
            enderecoSacAval.setLocalidade("Mogi das Cruzes");
            enderecoSacAval.setCep(new CEP("59000-000"));
            enderecoSacAval.setBairro("Centro");
            enderecoSacAval.setLogradouro("Rua Paulo Frontin");
            enderecoSacAval.setNumero("001");
            sacadorAvalista.addEndereco(enderecoSacAval);

            /*
                 * INFORMANDO OS DADOS SOBRE O TÍTULO.
             */
            // Informando dados sobre a conta bancária do título.
            ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
            contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
            contaBancaria.setCarteira(new Carteira(30));
            contaBancaria.setAgencia(new Agencia(1234, "1"));

            Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
            titulo.setNumeroDoDocumento("123456");
            titulo.setNossoNumero("99345678912");
            titulo.setDigitoDoNossoNumero("5");
            titulo.setValor(BigDecimal.valueOf(70.00));
            titulo.setDataDoDocumento(new Date());
            titulo.setDataDoVencimento(new Date());
            titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
            titulo.setAceite(Aceite.A);
            titulo.setDesconto(new BigDecimal(0.05));
            titulo.setDeducao(BigDecimal.ZERO);
            titulo.setMora(BigDecimal.ZERO);
            titulo.setAcrecimo(BigDecimal.ZERO);
            titulo.setValorCobrado(BigDecimal.valueOf(70.00));


            /*
                 * INFORMANDO OS DADOS SOBRE O BOLETO.
             */
            Boleto boleto = new Boleto(titulo);

            boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em "
                    + "qualquer Banco até o Vencimento.");
            boleto.setInstrucaoAoSacado("Este boleto é referente a campanha "
                    + "de doação X, através do site HelpHere!");
            boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
            boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
            boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
            boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
            boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
            boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
            boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
            boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

            /*
                 * GERANDO O BOLETO BANCÁRIO.
             */
            // Instanciando um objeto "BoletoViewer", classe responsável pela
            // geração do boleto bancário.
            BoletoViewer boletoViewer = new BoletoViewer(boleto);

            // Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
            // pasta do projeto. Outros exemplos:
            // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
            // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
            File arquivoPdf = boletoViewer.getPdfAsFile("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/pdf/MeuPrimeiroBoleto2.pdf");  
            System.out.println("antes de 5 segundo");
            new Thread().sleep(5000);
            System.out.println("despoi de 5 segundos");
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
            Logger.getLogger(GeraBoleto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GeraBoleto.class.getName()).log(Level.SEVERE, null, ex);
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
