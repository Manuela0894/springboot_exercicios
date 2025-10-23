
package com.login.genericLoginPage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.genericLoginPage.entity.Usuario;
import com.login.genericLoginPage.repositories.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//Endpoint
	@PostMapping(value = "usuario/cadastro")
	public ResponseEntity<?> saveUser(@RequestBody Usuario user) {
		Usuario usuario = new Usuario(user.getName(), user.getEmail(), user.getPassword());
		usuarioRepository.save(usuario);
		System.out.println("Usuário salvo com sucesso!");
		return ResponseEntity.ok("Salvo com sucesso");
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
	
	//criação da variável para o método
	@GetMapping(value = "metodo01")
	public List<Usuario> ListarUsuarios1(){
	List<Usuario>listaDeUsuario = usuarioRepository.findAll();
	return listaDeUsuario;
	}
	
	//sem criação de variável
	@GetMapping(value = "metodo02")
	public List<Usuario> ListarUsuarios(){
	return usuarioRepository.findAll();
	}
	
	
	@GetMapping(value = "{id}")
	public Optional<Usuario> usuarioPorId(@PathVariable int id){
	return usuarioRepository.findById(id);
	}

	//O Optional trata os erros uma vez que o id pode ou não ser retornado
}

