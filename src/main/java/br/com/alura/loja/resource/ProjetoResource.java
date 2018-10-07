/**
 * 
 */
package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Recurso web para projeto
 * @Path - URI a ser acessado no servidor. Ex: <url do servidor>/projetos
 * @GET - acesso pelo method GET
 * @Produces - o que ele vai produzir(XML, JSON entre outros).
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 7 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Path ( "projetos" )
public class ProjetoResource {

    @GET
    @Produces ( MediaType.APPLICATION_JSON )
    public String busca () {
        Projeto projeto = new ProjetoDAO().busca( 1l );
        
        return projeto.toJSON();
    }
}
