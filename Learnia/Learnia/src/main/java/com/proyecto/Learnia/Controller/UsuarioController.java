package com.proyecto.Learnia.Controller;

import com.proyecto.Learnia.Dto.LoginDTO;
import com.proyecto.Learnia.Entity.Usuario;
import com.proyecto.Learnia.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/get")
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario){
        Usuario creado = usuarioService.crear(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/{id}")
    public  Usuario buscar(@PathVariable  Integer id){
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable  Integer id, @Valid @RequestBody Usuario usuario){
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void eliminar(@PathVariable Integer id){
         usuarioService.eliminar(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody  LoginDTO loginDTO){
        return ResponseEntity.ok(usuarioService.login(loginDTO));
    }
}
