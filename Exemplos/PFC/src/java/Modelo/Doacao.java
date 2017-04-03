/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Date;

/**
 *
 * @author Diego
 */
public abstract class Doacao {
    private Date inicio;
    private Date dataFim;
    private Date dataCad;
    private String nome;
    private String descricao;
    private Pessoa responsavel;
    private Endereco endereco;
}
