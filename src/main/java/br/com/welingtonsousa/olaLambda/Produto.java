package br.com.welingtonsousa.olaLambda;

public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
	this.nome = nome;
	this.preco = preco;
    }

    public String getNome() {
	return nome;
    }

    public double getPreco() {
	return preco;
    }

    public void daDescontoDeVintePorCento() {
	preco = preco * 0.8;
    }

    public boolean acimaDeMil() {
	return preco > 1000.0;
    }

    @Override
    public String toString() {
	return "Produto [nome=" + nome + ", preco=" + preco + "]";
    }

    public void setPreco(double d) {
	this.preco = d;

    }

}
