
package com.login.genericLoginPage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.genericLoginPage.dto.ProdutoResponseDto;
import com.login.genericLoginPage.dto.UsuarioRequestDto;
import com.login.genericLoginPage.dto.UsuarioResponseDto;
import com.login.genericLoginPage.entity.Produto;
import com.login.genericLoginPage.entity.Usuario;
import com.login.genericLoginPage.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//Endpoint
	@PostMapping(value = "cadastro")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioRequestDto user) {
		Usuario usuario = new Usuario(user.getName(), user.getEmail(), user.getPassword());
		usuarioRepository.save(usuario);
		System.out.println("Usuário salvo com sucesso!");
		
		UsuarioResponseDto responseUsuario = new UsuarioResponseDto(usuario);
	  
	    return ResponseEntity.ok(responseUsuario);
		
	}
	
	// adicionar: se ususario ja esta cadastrado e tenta dnv: "faça o login" e vice versa
	
	@PostMapping (value = "login")
	public ResponseEntity<?> login(@RequestBody Usuario user){
		
		Usuario findUser = usuarioRepository.findByEmail(user.getEmail());
		usuarioRepository.findByEmail(user.getEmail());
		
		if(findUser == null) {
			
			return ResponseEntity.ok("Usuario não encontrado!");
			
		}else {
			
			if(findUser.getPassword().equals(user.getPassword())) {
				
				return ResponseEntity.ok("Logado com sucesso!");
				
			}else {
				return ResponseEntity.ok("Senha incorreta.");
				
			}

		}
		
	}
	
//	//criação da variável para o método
//	@GetMapping(value = "listagem")
//	public List<Usuario> ListarUsuarios1(){
//	List<Usuario>listaDeUsuario = usuarioRepository.findAll();
//	return listaDeUsuario;
//	}
	
	
	
		@GetMapping(value = "listagem")
		public List<UsuarioResponseDto> ListarUsuarios(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioResponseDto> listarUsuarios = usuarios.stream().map(UsuarioResponseDto::new).toList();
		return listarUsuarios;           
		}
	
	
//	//sem criação de variável
//	@GetMapping(value = "metodo02")
//	public List<Usuario> ListarUsuarios(){
//	return usuarioRepository.findAll();
//	}
//	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarId(@PathVariable int id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(usuario.isPresent()) {
			UsuarioResponseDto usuarioResearch = new UsuarioResponseDto(usuario.get());
			return ResponseEntity.status(HttpStatus.OK).body(usuarioResearch);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		}}
	

	//O Optional trata os erros uma vez que o id pode ou não ser retornado
	
	
	@DeleteMapping(value ="delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(usuario.isPresent()) {
			usuarioRepository.deleteById(id);
			System.out.println("Usuario com o id " + id + " deletado com sucesso!");
			return  ResponseEntity.ok("Usuário deletado com sucesso");
		}else {
			
			return ResponseEntity.status(404).body("Usuário não encontrado!");
		}

	}
	
	@PutMapping(value="update/{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable int id, @RequestBody Usuario user){
		Optional<Usuario> novoUsuario = usuarioRepository.findById(id);
		
		if(novoUsuario.isPresent()) {
			Usuario e = novoUsuario.get();
			e.setName(user.getName());
			e.setEmail(user.getEmail());
			e.setPassword(user.getPassword());
			usuarioRepository.save(e);
			return ResponseEntity.ok(novoUsuario);
			}	
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("produto não encontrado");
		}
		}
	
}

