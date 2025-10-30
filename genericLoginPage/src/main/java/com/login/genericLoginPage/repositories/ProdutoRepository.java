package com.login.genericLoginPage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.genericLoginPage.entity.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

	Produto findByNome(String nome);
	
	
}
