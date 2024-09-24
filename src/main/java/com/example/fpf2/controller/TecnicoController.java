package com.example.fpf2.controller;

import com.example.fpf2.model.Tecnico;
import com.example.fpf2.service.ItecnicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/tecnico")
@Slf4j
public class TecnicoController {

    ItecnicoService tecnicoService;

    public TecnicoController(ItecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> listarTecnicos(){
        List<Tecnico> l = this.tecnicoService.getAllTecnicos();
        log.info("Lista de Tecnicos: " + l);
        if(!l.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.getAllTecnicos());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.singletonMap("mensaje", "No se encontraron resultados"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTecnico(@PathVariable Long id){
        if (this.tecnicoService.getTecnicoById(id) != null){
            return ResponseEntity.ok(this.tecnicoService.getTecnicoById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("mensaje", "No se encontró técnico para actualizar"));
    }

    @PostMapping({"/", ""})
    public ResponseEntity<?> salvarTecnico(@RequestBody Tecnico tecnico){
        if (!tecnico.getNombre().isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.tecnicoService.saveTecnico(tecnico));
        }
        return ResponseEntity.badRequest().body("No se pudo procesar la solicitud.");
    }
}
