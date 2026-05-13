package com.proyecto.Learnia.controller;

import com.proyecto.Learnia.entity.Pregunta;
import com.proyecto.Learnia.entity.Respuesta;
import com.proyecto.Learnia.entity.Usuario;
import com.proyecto.Learnia.repository.RespuestaRepository;
import com.proyecto.Learnia.repository.UsuarioRepository;
import com.proyecto.Learnia.service.PreguntaService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PreguntaDetalleController {

    private final PreguntaService preguntaService;
    private final RespuestaRepository respuestaRepository;
    private final UsuarioRepository usuarioRepository;

    public PreguntaDetalleController(PreguntaService preguntaService,
                                     RespuestaRepository respuestaRepository,
                                     UsuarioRepository usuarioRepository) {
        this.preguntaService = preguntaService;
        this.respuestaRepository = respuestaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/pregunta/{id}")
    public String verPregunta(@PathVariable Long id,
                              Model model,
                              @AuthenticationPrincipal UserDetails userDetails) {
        Pregunta pregunta = preguntaService.buscarPorId(id);
        List<Respuesta> respuestas = respuestaRepository.findByPregunta_IdPregunta(id);

        Usuario usuario = usuarioRepository
                .findByCorreoUsuario(userDetails.getUsername())
                .orElseThrow();

        model.addAttribute("pregunta", pregunta);
        model.addAttribute("respuestas", respuestas);
        model.addAttribute("usuario", usuario);

        return "pregunta-detalle";
    }
}