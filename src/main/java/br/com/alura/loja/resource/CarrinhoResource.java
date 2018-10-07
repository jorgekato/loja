/**
 * 
 */
package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Recurso web para carrinho.
 * @Path - URI a ser acessado no servidor. Ex: <url do servidor>/carrinhos
 * @GET - acesso pelo method GET
 * @Produces - o que ele vai produzir(XML, JSON entre outros).
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 4 de out de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Path("carrinhos")
public class CarrinhoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String busca() {
        Carrinho carrinho = new CarrinhoDAO().busca(1l);
        
        return carrinho.toJSON();
    }

}
