package br.com.welingtonsousa.olaLambda;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

    private List<Produto> produtos;

    @Before
    public void inicializa() {
	this.produtos = new ArrayList<>();
    }

    @Test
    public void deveMostrarAListagemDeProdutos() {
	produtos.add(new Produto("Racket de Tenis", 300));
	produtos.add(new Produto("Camiseta StarWars", 80));

	assertEquals(2, produtos.size());
	produtos.forEach(p -> System.out.println(p));
    }

    @Test
    public void deveDarDescontoDeVintePorCentoAosProdutos() {
	produtos.add(new Produto("Racket de Tenis", 300));
	produtos.add(new Produto("Camiseta StarWars", 80));

	produtos.forEach(Produto::daDescontoDeVintePorCento);

	assertEquals(2, produtos.size());
	produtos.forEach(System.out::println);
    }

    @Test
    public void deveDarDescontaParaProdutosAcimaDeCem() {
	produtos.add(new Produto("Racket de Tenis", 300));
	produtos.add(new Produto("Camiseta StarWars", 80));

	CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos);
	carrinho.daDesconto(30, p -> p.getPreco() > 100);

	assertEquals(2, produtos.size());
	produtos.forEach(System.out::println);
    }

    @Test
    public void deveDarDescontoDeDezPorCentoParaCamisetasSemEstampa() {
	produtos.add(new Produto("Racket de Tenis", 300));
	produtos.add(new Produto("Camiseta sem estampa", 80));

	CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos);
	carrinho.daDesconto(10,
		p -> p.getNome().contains("Camiseta sem estampa"));

	assertEquals(2, produtos.size());
	produtos.forEach(System.out::println);
    }

    @Test
    public void deveDarDescontaDeCinquentaPorCentoParaProdutosAcimaDeMil() {
	produtos.add(new Produto("Racket de Tenis", 3000));
	produtos.add(new Produto("Camiseta StarWars", 80));

	CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos);
	carrinho.daDesconto(50, Produto::acimaDeMil);

	assertEquals(2, produtos.size());
	produtos.forEach(System.out::println);
    }

}
