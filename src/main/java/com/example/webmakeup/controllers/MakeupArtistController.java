package com.example.webmakeup.controllers;

import com.example.webmakeup.models.MakeupArtist;
import com.example.webmakeup.services.MakeupArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class MakeupArtistController {
    @Autowired
    private MakeupArtistService makeupArtistService;

    // Thêm chuyên gia trang điểm mới
    @PostMapping
    public MakeupArtist addArtist(@RequestBody MakeupArtist artist) {
        return makeupArtistService.addArtist(artist);
    }

    // Lấy danh sách tất cả chuyên gia trang điểm
    @GetMapping
    public List<MakeupArtist> getAllArtists() {
        return makeupArtistService.getAllArtists();
    }

    // Lấy thông tin chuyên gia theo ID
    @GetMapping("/{id}")
    public MakeupArtist getArtistById(@PathVariable Long id) {
        return makeupArtistService.getArtistById(id);
    }

    // Cập nhật thông tin chuyên gia trang điểm
    @PutMapping("/{id}")
    public MakeupArtist updateArtist(@PathVariable Long id, @RequestBody MakeupArtist updatedArtist) {
        return makeupArtistService.updateArtist(id, updatedArtist);
    }

    // Xóa chuyên gia trang điểm
    @DeleteMapping("/{id}")
    public String deleteArtist(@PathVariable Long id) {
        makeupArtistService.deleteArtist(id);
        return "Makeup artist deleted successfully";
    }
}