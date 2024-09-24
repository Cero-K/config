package com.example.fpf2.service;

import com.example.fpf2.model.Tecnico;

import java.util.List;

public interface ItecnicoService {
    public Tecnico getTecnicoById(Long id);
    public List<Tecnico> getAllTecnicos();
    public Tecnico saveTecnico(Tecnico tecnico);
    public Tecnico updateTecnico(Tecnico tecnico, Long id);
    public void deleteTecnico(Long id);
}
