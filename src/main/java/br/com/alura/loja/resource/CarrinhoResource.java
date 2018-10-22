/**
 * 
 */
package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Recurso web para carrinho.
 * 
 * @Path - URI a ser acessado no servidor. Ex: <url do servidor>/carrinhos
 * @GET - acesso pelo method GET
 * @Produces - o que ele vai produzir(XML, JSON entre outros). <br>
 *           HISTÓRICO DE DESENVOLVIMENTO: <br>
 *           4 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 *           <br>
 *           <br>
 *           LISTA DE CLASSES INTERNAS: <br>
 */

@Path ( "carrinhos" )
public class CarrinhoResource {

    @Path ( "{id}" )
    @GET
    @Produces ( MediaType.APPLICATION_JSON ) // tipo de informação produzida.
    public String busca ( @PathParam ( "id" ) long id ) {
        Carrinho carrinho = new CarrinhoDAO().busca( id );

        return carrinho.toJSON();
    }

    @POST
    @Consumes ( MediaType.APPLICATION_JSON ) // tipo de informação consumida.
    public Response adiciona ( String conteudo ) {
        Carrinho carrinho = new Gson().fromJson( conteudo , Carrinho.class );
        new CarrinhoDAO().adiciona( carrinho );
        URI uri = URI.create( "/carrinhos/" + carrinho.getId() );
        return Response.created( uri ).build();// devolve uma resposta http - CODE: 200(OK),201(CREATED),401(NOT
                                               // FOUND),500(INTERN SERVER ERROR)...
    }
    @Path("{id}")
    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    public Response adicionaProduto(@PathParam("id") long id, String conteudo) {
        Produto prod = new Gson().fromJson( conteudo , Produto.class );
        Carrinho carrinho = new CarrinhoDAO().busca( id );
        carrinho.adiciona( prod );
        URI uri = URI.create( "/carrinhos/" + carrinho.getId() + "/" + prod.getId() );
        return Response.created( uri  ).build();
        
    }

    @Path ( "{id}/produtos/{produtoId}" )
    @DELETE
    public Response removeProduto ( @PathParam ( "id" ) long id , @PathParam ( "produtoId" ) long produtoId ) {

        Carrinho carrinho = new CarrinhoDAO().busca( id );
        carrinho.remove( produtoId );
        return Response.ok().build();
    }

    @Path ( "{id}" )
    @DELETE
    public Response removeCarrinho ( @PathParam ( "id" ) long id ) {
        
        new CarrinhoDAO().remove( id );
        
        return Response.ok().build();
    }
    
    /**
     * 
     * Método que realiza a alteração do produto no carrinho indicado.
     * @param conteudo - produto em formato Gson
     * @param id       - id do carrinho
     * @param produtoId- id do produto
     * @return
     */
    @Path("{id}/produtos/{produtoId}")
    @PUT
    public Response trocaProduto(String conteudo, @PathParam("id") Long id, @PathParam("produtoId") Long produtoId) {
        
        Carrinho carrinho = new CarrinhoDAO().busca( id );
        Produto produto = new Gson().fromJson( conteudo, Produto.class );
        carrinho.troca( produto );
        
        return Response.ok().build();
    }

    /**
     * 
     * Método que realiza a alteração da quantidade do produto indicado no carrinho indicado.
     * @param conteudo - produto em formato Gson
     * @param id       - id do carrinho
     * @param produtoId- id do produto
     * @return
     */
    @Path("{id}/produtos/{produotoId}/quantidade")
    @PUT
    public Response trocaQuantidadeProduto(String conteudo, @PathParam("id") Long id, @PathParam("produtoId") Long produtoId) {
        
        Carrinho carrinho = new CarrinhoDAO().busca( id );
        Produto produto = new Gson().fromJson( conteudo, Produto.class );
        carrinho.trocaQuantidade( produto );
        
        return Response.ok().build();
    }

}
