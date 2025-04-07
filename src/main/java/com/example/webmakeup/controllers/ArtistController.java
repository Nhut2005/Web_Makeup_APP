package com.example.webmakeup.controllers;

import com.example.webmakeup.models.Artist;
import com.example.webmakeup.models.WorkSchedule;
import com.example.webmakeup.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        Artist createdArtist = artistService.createArtist(artist);
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.getArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist updatedArtist = artistService.updateArtist(id, artist);
        return new ResponseEntity<>(updatedArtist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{artistId}/schedule")
    public ResponseEntity<WorkSchedule> createWorkSchedule(@PathVariable Long artistId, @RequestBody WorkSchedule workSchedule) {
        WorkSchedule createdSchedule = artistService.createWorkSchedule(artistId, workSchedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    @GetMapping("/{artistId}/schedule")
    public ResponseEntity<List<WorkSchedule>> getWorkSchedules(@PathVariable Long artistId) {
        List<WorkSchedule> schedules = artistService.getWorkSchedulesByArtist(artistId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
}