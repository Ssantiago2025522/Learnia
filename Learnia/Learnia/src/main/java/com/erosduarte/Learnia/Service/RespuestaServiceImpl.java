package com.erosduarte.Learnia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.erosduarte.Learnia.Entity.Respuesta;
import com.erosduarte.Learnia.Repository.RespuestaRepository;
import com.erosduarte.Learnia.Service.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public List<Respuesta> listar() {
        return respuestaRepository.findAll();
    }

    @Override
    public Respuesta guardar(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @Override
    public Respuesta buscarPorId(Long id) {
        return respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
    }

    @Override
    public Respuesta actualizar(Long id, Respuesta nuevaRespuesta) {
        Respuesta existente = buscarPorId(id);
        existente.setContenido(nuevaRespuesta.getContenido());
        return respuestaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        respuestaRepository.deleteById(id);
    }
}