package com.login.genericLoginPage.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequestDto {


		@NotBlank(message="O nome não pode ser nulo")
		private String nome;
		
		@NotNull(message="O preço é necessário")
		private double preco;
		
		@Min(value = 1, message = "A quantidade deve ser no mínimo 1")
	    @Max(value = 100, message = "A quantidade deve ser no máximo 1000")
		private int quantidade;

		public ProdutoRequestDto() {}
		
		public ProdutoRequestDto(String nome, double preco, int quantidade) {
			this.nome = nome;
			this.preco = preco;
			this.quantidade = quantidade;
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

	
	

