/**
 * 
 */
package br.com.alura.loja.resource;

import java.net.URI;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Recurso web para projeto
 * 
 * @Path - URI a ser acessado no servidor. Ex: <url do servidor>/projetos
 * @GET - acesso pelo method GET
 * @Produces - o que ele vai produzir(XML, JSON entre outros). <br>
 *           HISTÓRICO DE DESENVOLVIMENTO: <br>
 *           7 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 *           <br>
 *           <br>
 *           LISTA DE CLASSES INTERNAS: <br>
 */

@Path ( "projetos" )
public class ProjetoResource {

//    @Path ( "{id}" )
//    @GET
//    @Produces ( MediaType.APPLICATION_JSON )
//    public String busca ( @PathParam ( "id" ) long id ) {
//        Projeto projeto = new ProjetoDAO().busca( id );
//
//        return projeto.toJSON();
//    }
    
    @Path ( "{id}" )
    @GET
    @Produces ( MediaType.APPLICATION_XML  )
    public Projeto busca ( @PathParam ( "id" ) long id ) {
        Projeto projeto = new ProjetoDAO().busca( id );
        
        return projeto;
    }
    
    /**
     * Método que utiliza o JAXB para serializar o xml e adicionar o novo projeto.
     * TODO Descrição do Método
     * @param conteudo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response adiciona(Projeto projeto) {
        new ProjetoDAO().adiciona( projeto );
        URI uri = URI.create( "/projetos/" + projeto.getId() );
        return Response.created( uri ).build();
    }
    /**
     * Metodo que não utiliza o JAXB para serializar o xml
     * TODO Descrição do Método
     * @param id
     * @return
     */
//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    public Response adiciona(String conteudo) {
//        Projeto projeto = ( Projeto ) new XStream().fromXML( conteudo );
//        new ProjetoDAO().adiciona( projeto );
//        URI uri = URI.create( "/projetos/" + projeto.getId() );
//        return Response.created( uri ).build();
//    }
    
    @Path ("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeProjeto(@PathParam("id") Long id) {
         new ProjetoDAO().remove( id );
        return Response.ok().build();
        
    }
}
