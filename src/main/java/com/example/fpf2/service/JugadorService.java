package com.example.fpf2.service;

import com.example.fpf2.model.Club;
import com.example.fpf2.model.Jugador;
import com.example.fpf2.model.repository.IClubRepository;
import com.example.fpf2.model.repository.IJugadorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Slf4j
@Service
public class JugadorService implements IJugadorService {
    IJugadorRepository jugadorRepository;
    IClubRepository clubRepository;

    public JugadorService(IJugadorRepository jugadorRepository, IClubRepository clubRepository) {
        this.jugadorRepository = jugadorRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public Jugador saveJugador(Jugador jugador) {
        log.info(jugador.toString());
        if (jugador.getClub().getId() != null) {
            log.info(jugador.getClub().getId().toString());
            return jugadorRepository.save(jugador);
        }
        return null;
    }

    @Override
    public List<Jugador> ListaJugadoresPorClub(Long idClub) {
        return this.jugadorRepository.listarJugadorPorClub(idClub);
    }
}
