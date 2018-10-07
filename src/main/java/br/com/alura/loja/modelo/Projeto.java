/**
 * 
 */
package br.com.alura.loja.modelo;

import org.json.JSONObject;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 7 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class Projeto {

    private long id;
    private String nome;
    private int anoDeInicio;

    /**
     * TODO Construtor padrão/alternativo da classe
     * 
     * @param id
     * @param nome
     * @param anoDeInicio
     */
    public Projeto ( long id , String nome , int anoDeInicio ) {
        super();
        this.id = id;
        this.nome = nome;
        this.anoDeInicio = anoDeInicio;
    }

    /**
     * Método de recuperação do campo id
     *
     * @return valor do campo id
     */
    public long getId () {
        return id;
    }

    /**
     * Valor de id atribuído a id
     *
     * @param id
     *            Atributo da Classe
     */
    public void setId ( long id ) {
        this.id = id;
    }

    /**
     * Método de recuperação do campo nome
     *
     * @return valor do campo nome
     */
    public String getNome () {
        return nome;
    }

    /**
     * Valor de nome atribuído a nome
     *
     * @param nome
     *            Atributo da Classe
     */
    public void setNome ( String nome ) {
        this.nome = nome;
    }

    /**
     * Método de recuperação do campo anoDeInicio
     *
     * @return valor do campo anoDeInicio
     */
    public int getAnoDeInicio () {
        return anoDeInicio;
    }

    /**
     * Valor de anoDeInicio atribuído a anoDeInicio
     *
     * @param anoDeInicio
     *            Atributo da Classe
     */
    public void setAnoDeInicio ( int anoDeInicio ) {
        this.anoDeInicio = anoDeInicio;
    }
    
    /** 
     * TODO Descrição do Método
     * @return
     */
    public String toJSON () {
        
        
        return new JSONObject( this ).toString();
    }

}
