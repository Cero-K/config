package com.example.fpf2.service;

import com.example.fpf2.model.Tecnico;
import com.example.fpf2.model.repository.ITecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService implements ItecnicoService{

    ITecnicoRepository tecnicoRepository;

    public TecnicoService(ITecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    @Override
    public Tecnico getTecnicoById(Long id) {
        return this.tecnicoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Tecnico> getAllTecnicos() {
        return (List<Tecnico>) this.tecnicoRepository.findAll();
    }

    @Override
    public Tecnico saveTecnico(Tecnico tecnico) {
        return this.tecnicoRepository.save(tecnico);
    }

    @Override
    public Tecnico updateTecnico(Tecnico tecnico, Long id) {
        Tecnico temp = this.tecnicoRepository.findById(id).orElseThrow();
        temp.setNombre(tecnico.getNombre());
        this.tecnicoRepository.save(temp);
        return temp;
    }

    @Override
    public void deleteTecnico(Long id) {
        this.tecnicoRepository.deleteById(id);
    }
}
