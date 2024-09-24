package com.example.fpf2.controller;

import com.example.fpf2.model.Club;
import com.example.fpf2.service.IClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/club")

public class ClubController {
    IClubService clubService;

    public ClubController(IClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> guardarClub(@RequestBody Club club) {
       if (club.getTecnico() == null || club.getTecnico().getNombre() == null || club.getTecnico().getNombre().equals(""))  {
           return ResponseEntity.badRequest().body("El Tecnico no puede ser nulo");
       }
        return ResponseEntity.ok(clubService.saveClub(club));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> listarClub() {
        return ResponseEntity.ok(this.clubService.getAllClubs());
    }
}
