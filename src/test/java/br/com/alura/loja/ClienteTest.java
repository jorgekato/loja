/**
 * 
 */
package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;
import junit.framework.Assert;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 1 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class ClienteTest {

    private HttpServer server;

    @Before
    public void iniciaServidor () {
        server = Servidor.inicializaServidor();
    }

    @After
    public void encerraServidor () {
        server.stop();
    }

    // @Test
    // public void testaQueAConexaoComOServidorFunciona() {
    // Client client = ClientBuilder.newClient();
    // WebTarget target = client.target( "http://www.mocky.io" );
    // String conteudo = target.path( "/v2/52aaf5deee7ba8c70329fb7d"
    // ).request().get(String.class);
    // Assert.assertTrue( conteudo.contains( "<rua>Rua Vergueiro 3185" ) );
    // }

//    @Test
//    public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado () {
//
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target( "http://localhost:8080" );
//        String conteudo = target.path( "/carrinhos" ).request().get( String.class );
//        System.out.println( conteudo );
//        Gson gson = new Gson();
//        Carrinho carrinho = gson.fromJson( conteudo , Carrinho.class );
//        Assert.assertEquals( "Rua Vergueiro 3185, 8 andar" , carrinho.getRua() );
//
//    }

//    @Test
//    public void testaQueAConexaoComOServidorFuncionaNoPathDeProjetos () {
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target( "http://localhost:8080" );
//        String conteudo = target.path( "/projetos" ).request().get( String.class );
//        Assert.assertTrue( conteudo.contains( "Minha loja" ) );
//
//    }

    @Test
    public void testaQueBuscarUmCarrinhoTrazOProjetoEsperado () {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target( "http://localhost:8080" );
        String conteudo = target.path( "/projetos" ).request().get( String.class );
        System.out.println( conteudo );
        Gson gson = new Gson();
        Projeto projeto = gson.fromJson( conteudo , Projeto.class );
        Assert.assertEquals( "Minha loja" , projeto.getNome() );

    }

}
