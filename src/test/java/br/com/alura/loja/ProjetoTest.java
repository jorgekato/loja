/**
 * 
 */
package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Projeto;
import junit.framework.Assert;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 21 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class ProjetoTest {
    
    private HttpServer server;
    private Client client;
    private WebTarget target;

    @Before
    public void iniciaServidor() {
        server = Servidor.inicializaServidor();
        
        ClientConfig config = new ClientConfig();
        config.register( new LoggingFilter() );
        this.client = ClientBuilder.newClient(config);
        target = client.target( "http://localhost:8080" );
    }

    @After
    public void encerraServidor() {
        server.stop();
    }
    
    @Test
    public void testaQueAConexaoComOServidorFuncionaNoPathDeProjetos() {
        WebTarget target = client.target("http://localhost:8080");
        Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
        Assert.assertEquals(1L, projeto.getId(),0);

    }
    
    @Test
    public void testaQueBuscaUmProjetoEsperado() {
        Projeto projeto = target.path( "/projetos/1" ).request().get(Projeto.class);
        Assert.assertEquals( "Minha loja" , projeto.getNome() );
    }
}
