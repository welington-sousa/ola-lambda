package br.com.welingtonsousa.olaLambda;

import java.util.List;

public class CarrinhoDeCompras {

    private List<Produto> produtos;

    public CarrinhoDeCompras(List<Produto> produtos) {
	this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
	return produtos;
    }

    public void daDesconto(int porcentagem, Condicao<Produto> condicao) {
	for (Produto p : produtos) {
	    if (condicao.inclui(p)) {
		p.setPreco(p.getPreco() * (100 - porcentagem) / 100);
	    }
	}
    }

}
