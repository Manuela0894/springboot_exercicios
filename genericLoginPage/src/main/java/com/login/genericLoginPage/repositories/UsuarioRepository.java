<<<<<<< HEAD
package com.login.genericLoginPage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.genericLoginPage.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	//método p procurar pelo email
	
	Usuario findByEmail(String email);
	
	

}
=======
package com.login.genericLoginPage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.genericLoginPage.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	//método p procurar pelo email
	
	Usuario findByEmail(String email);
	
	

}
>>>>>>> origin/main
