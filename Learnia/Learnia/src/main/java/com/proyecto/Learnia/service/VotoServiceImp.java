package com.proyecto.Learnia.service;

import com.proyecto.Learnia.entity.Voto;
import com.proyecto.Learnia.repository.VotoRepository;
import com.proyecto.Learnia.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoServiceImp implements VotoService {

    private final VotoRepository votoRepository;

    public VotoServiceImp(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    @Override
    public List<Voto> listar() {
        return votoRepository.findAll();
    }

    @Override
    public Voto crear(Voto voto) {
        voto.setIdVoto(null);
        return votoRepository.save(voto);
    }

    @Override
    public Voto buscarPorId(Long id) {
        return votoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voto no encontrado con ID: " + id));
    }

    @Override
    public Voto actualizar(Long id, Voto voto) {
        Voto existente = buscarPorId(id);

        existente.setTipo(voto.getTipo());
        existente.setIdRespuesta(voto.getIdRespuesta());

        return votoRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!votoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Voto no encontrado con ID: " + id);
        }
        votoRepository.deleteById(id);
    }
}