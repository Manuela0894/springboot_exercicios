 package com.login.genericLoginPage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.genericLoginPage.dto.ProdutoRequestDto;
import com.login.genericLoginPage.dto.ProdutoResponseDto;
import com.login.genericLoginPage.dto.UsuarioResponseDto;
import com.login.genericLoginPage.entity.Produto;
import com.login.genericLoginPage.repositories.ProdutoRepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value ="produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("{id}")
	public ResponseEntity<?> buscarId(@PathVariable int id){
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.isPresent()) {
			ProdutoResponseDto produtoResearch = new ProdutoResponseDto(produto.get());
			return ResponseEntity.status(HttpStatus.OK).body(produtoResearch);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
			}
		}
		
		
		@GetMapping("list")
		public List<ProdutoResponseDto> buscarProdutos(){
			List<Produto> produtos = produtoRepository.findAll();
			List<ProdutoResponseDto> listarProdutos = produtos.stream().map(ProdutoResponseDto::new).toList();
				return listarProdutos;
	}
		
		
		@PostMapping("create")
		public ResponseEntity<?> criarProduto(@Valid @RequestBody ProdutoRequestDto produto){
		Produto novoProduto  = new Produto(
				produto.getNome(), produto.getPreco(), produto.getQuantidade());
				produtoRepository.save(novoProduto);
				
				ProdutoResponseDto responseProduto = new ProdutoResponseDto(novoProduto);
				  
				return ResponseEntity.ok(responseProduto);
				
			}
		
		@DeleteMapping(value="delete/{id}")
		public ResponseEntity<?> deletarId(@PathVariable int id){
			boolean produto = produtoRepository.existsById(id);
			
			if(produto) {
				produtoRepository.deleteById(id);
				return ResponseEntity.ok("deletado com sucesso");
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("produto não encontrado");
				}
			}
		
		@PutMapping(value="update/{id}")
		public ResponseEntity<?> atualizarProduto(@PathVariable int id, @RequestBody Produto produto){
			Optional<Produto> novoProduto = produtoRepository.findById(id);
			
			if(novoProduto.isPresent()) {
				Produto e = novoProduto.get();
				e.setNome(produto.getNome());
				e.setPreco(produto.getPreco());
				e.setQuantidade(produto.getQuantidade());
				produtoRepository.save(e);
				return ResponseEntity.ok(novoProduto);
				}	
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("produto não encontrado");
		}
	}
}
