package com.example.webmakeup.services;

import com.example.webmakeup.models.Artist;
import com.example.webmakeup.models.WorkSchedule;

import java.util.List;

public interface ArtistService {
    Artist createArtist(Artist artist);
    List<Artist> getAllArtists();
    Artist getArtistById(Long id);
    Artist updateArtist(Long id, Artist artist);
    void deleteArtist(Long id);

    WorkSchedule createWorkSchedule(Long artistId, WorkSchedule workSchedule);
    List<WorkSchedule> getWorkSchedulesByArtist(Long artistId);
    List<WorkSchedule> getAvailableSchedules();
}