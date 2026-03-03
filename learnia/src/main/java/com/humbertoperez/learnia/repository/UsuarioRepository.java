package com.humbertoperez.Learnia.Repository;

import com.humbertoperez.Learnia.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
