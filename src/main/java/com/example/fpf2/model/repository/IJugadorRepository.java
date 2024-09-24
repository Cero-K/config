package com.example.fpf2.model.repository;

import com.example.fpf2.model.Jugador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IJugadorRepository extends CrudRepository<Jugador, Long> {

    @Query(value = "Select * from jugadores where club_id = ?1", nativeQuery = true)
    public List<Jugador> listarJugadorPorClub(Long id);
}
