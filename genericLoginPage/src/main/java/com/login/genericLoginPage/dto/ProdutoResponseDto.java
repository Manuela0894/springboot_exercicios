package com.login.genericLoginPage.dto;

import com.login.genericLoginPage.entity.Produto;

public class ProdutoResponseDto {

	private String nome;
	private double preco;
	private int quantidade;
	
	public ProdutoResponseDto(Produto produto) {
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.quantidade = produto.getQuantidade();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
}
