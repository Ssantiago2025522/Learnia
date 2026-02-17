package com.erosduarte.Learnia.Repository;

import com.erosduarte.Learnia.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
