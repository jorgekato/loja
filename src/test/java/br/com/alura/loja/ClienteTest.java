/**
 * 
 */
package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import junit.framework.Assert;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 1 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class ClienteTest {

    @Test
    public void testaQueAConexaoComOServidorFunciona() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target( "http://www.mocky.io" );
        String conteudo = target.path( "/v2/52aaf5deee7ba8c70329fb7d" ).request().get(String.class);
        System.out.println( conteudo );
        Assert.assertTrue( conteudo.contains( "<rua>Rua Vergueiro 3185" ) );
    }

}
