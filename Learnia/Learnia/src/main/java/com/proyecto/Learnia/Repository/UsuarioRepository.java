package com.proyecto.Learnia.Repository;

import com.proyecto.Learnia.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
