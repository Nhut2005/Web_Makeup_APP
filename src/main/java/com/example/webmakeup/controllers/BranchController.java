package com.example.webmakeup.controllers;

import com.example.webmakeup.models.Branch;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final List<Branch> branches = new ArrayList<>();

    public BranchController() {
        // Khởi tạo dữ liệu mẫu (nếu muốn có sẵn vài chi nhánh)
        branches.add(new Branch("Trụ sở chính", "123 Nguyễn Huệ, Quận 1, TP.HCM", "(028) 3823 4567", "hq@makeupartist.com", "8:00 - 16:00", "9:00 - 16:00"));
        branches.add(new Branch("Chi nhánh Quận 1", "45 Lê Lợi, Quận 1, TP.HCM", "(028) 3823 4568", "q1@makeupartist.com", "8:00 - 16:00", "8:00 - 16:00"));
        branches.add(new Branch("Chi nhánh Quận 3", "78 Võ Văn Tần, Quận 3, TP.HCM", "(028) 3823 4569", "q3@makeupartist.com", "8:00 - 16:00", "8:00 - 17:00"));
    }

    @GetMapping
    public List<Branch> getAllBranches() {
        return branches;
    }

    @PostMapping
    public Branch addBranch(@RequestBody Branch branch) {
        branches.add(branch);
        return branch;
    }
}
