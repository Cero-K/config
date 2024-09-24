package com.example.fpf2.controller;

import com.example.fpf2.model.Jugador;
import com.example.fpf2.service.IJugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping({"/api/jugador"})
public class JugadorController {

    IJugadorService jugadorService;

    public JugadorController(IJugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> guardarJugador(@RequestBody Jugador jugador) {
        if (this.jugadorService.saveJugador(jugador) != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarJugador(@PathVariable Long id) {
        if (this.jugadorService.ListaJugadoresPorClub(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("mensaje", "No se encontró club de jugador"));
        }
        return ResponseEntity.ok(this.jugadorService.ListaJugadoresPorClub(id));
    }
}
