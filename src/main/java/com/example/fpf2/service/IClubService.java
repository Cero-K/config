package com.example.fpf2.service;

import com.example.fpf2.model.Club;

import java.util.List;

public interface IClubService {
    public List<Club> getAllClubs();
    public Club getClubById(Long id);
    public Club saveClub(Club club);
    public Club updateClub(Club club, Long id);
    public void deleteClub(Long id);

}
