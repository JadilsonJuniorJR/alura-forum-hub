package br.com.forum.alura.repository;

import br.com.forum.alura.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);


    UserDetails findByNome(String nome);

//    UserDetails findByEmail(String email);

    UserDetails findByEmail(String email);
}
