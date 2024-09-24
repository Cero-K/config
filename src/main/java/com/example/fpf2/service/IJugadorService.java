package com.example.fpf2.service;

import com.example.fpf2.model.Jugador;

import java.util.List;

public interface IJugadorService {
    public Jugador saveJugador(Jugador jugador);
    public List<Jugador> ListaJugadoresPorClub(Long idClub);


}
