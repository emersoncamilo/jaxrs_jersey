package br.com.loja.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Map busca() {
		System.out.println("Buscando todos os registros... ");
		Map carrinho = new CarrinhoDAO().buscaTodos();
		return carrinho;
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") Long id) {
		System.out.println("Buscando o carrinho com ID: "+id);
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho.toXML();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String adiciona(String conteudo) {
		System.out.println("Adicionando o Carrinho... ");
		System.out.println(conteudo);
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		return "<status>sucesso</status>";
	}
}