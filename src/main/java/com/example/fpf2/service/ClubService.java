package com.example.fpf2.service;

import com.example.fpf2.model.Club;
import com.example.fpf2.model.repository.IClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubService implements IClubService {

    IClubRepository clubRepository;

    public ClubService(IClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Club> getAllClubs() {
        return (List<Club>) this.clubRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Club getClubById(Long id) {
        return this.clubRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Club saveClub(Club club) {

        return this.clubRepository.save(club);

    }

    @Override
    public Club updateClub(Club club, Long id) {
        Club c = this.clubRepository.findById(id).orElseThrow();
        c.setNombre(club.getNombre());
        this.clubRepository.save(c);
        return c;
    }

    @Override
    public void deleteClub(Long id) {
        this.clubRepository.deleteById(id);
    }
}
