/**
 * 
 */
package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe que contém o método principal para rodar o servidor web.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 4 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class Servidor {
    public static void main ( String[] args ) throws IOException {

        HttpServer server = inicializaServidor();
        System.out.println( "Servidor rodando..." );
        System.in.read();
        server.stop();
        
    }

    /** 
     * Método static que inicializa o servidor.
     * @return
     */
    static HttpServer inicializaServidor () {
        URI uri = URI.create( "http://localhost:8080" );
        ResourceConfig config = new ResourceConfig().packages( "br.com.alura.loja" );//conf dos recursos a ser utilizados do jax-rs
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer( uri, config  );
        return server;
    }
}
