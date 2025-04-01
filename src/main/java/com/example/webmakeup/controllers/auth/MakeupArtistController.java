package com.example.webmakeup.controllers.auth;

import com.example.webmakeup.models.MakeupArtist;
import com.example.webmakeup.services.MakeupArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class MakeupArtistController {
    @Autowired
    private MakeupArtistService makeupArtistService;

    // Thêm chuyên gia trang điểm mới
    @PostMapping
    public MakeupArtist createMakeupArtist(@RequestBody MakeupArtist artist) {
        return makeupArtistService.createMakeupArtist(artist);
    }

    // Lấy danh sách tất cả chuyên gia trang điểm
    @GetMapping
    public List<MakeupArtist> getAllMakeupArtists() {
        return makeupArtistService.getAllMakeupArtists();
    }

    // Lấy thông tin chuyên gia theo ID
    @GetMapping("/{id}")
    public ResponseEntity<MakeupArtist> getMakeupArtistById(@PathVariable Long id) {
        Optional<MakeupArtist> artist = makeupArtistService.getMakeupArtistById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cập nhật thông tin chuyên gia trang điểm
    @PutMapping("/{id}")
    public ResponseEntity<MakeupArtist> updateMakeupArtist(@PathVariable Long id, @RequestBody MakeupArtist updatedArtist) {
        Optional<MakeupArtist> updated = makeupArtistService.updateMakeupArtist(id, updatedArtist);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa chuyên gia trang điểm
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMakeupArtist(@PathVariable Long id) {
        if (makeupArtistService.deleteMakeupArtist(id)) {
            return ResponseEntity.ok("Makeup artist deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}