package com.example.webmakeup.services;

import com.example.webmakeup.models.Artist;
import com.example.webmakeup.models.WorkSchedule;
import com.example.webmakeup.repositories.ArtistRepository;
import com.example.webmakeup.repositories.WorkScheduleRepository;
import com.example.webmakeup.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    @Override
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    @Override
    public Artist updateArtist(Long id, Artist artist) {
        Artist existingArtist = getArtistById(id);
        existingArtist.setName(artist.getName());
        existingArtist.setSpecialization(artist.getSpecialization());
        existingArtist.setPhoneNumber(artist.getPhoneNumber());
        existingArtist.setEmail(artist.getEmail());
        return artistRepository.save(existingArtist);
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public WorkSchedule createWorkSchedule(Long artistId, WorkSchedule workSchedule) {
        Artist artist = getArtistById(artistId);
        workSchedule.setArtist(artist);
        return workScheduleRepository.save(workSchedule);
    }

    @Override
    public List<WorkSchedule> getWorkSchedulesByArtist(Long artistId) {
        return workScheduleRepository.findByArtistId(artistId);
    }

    @Override
    public List<WorkSchedule> getAvailableSchedules() {
        return workScheduleRepository.findByIsAvailableTrue();
    }
}
