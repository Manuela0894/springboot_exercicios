
package com.login.genericLoginPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
}

