package com.example.webmakeup.services;


import com.example.webmakeup.models.Branch;
import com.example.webmakeup.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        return branch.orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @Override
    public Branch updateBranch(Long id, Branch branch) {
        Branch existingBranch = getBranchById(id);
        existingBranch.setName(branch.getName());
        existingBranch.setAddress(branch.getAddress());
        existingBranch.setPhoneNumber(branch.getPhoneNumber());
        existingBranch.setEmail(branch.getEmail());
        return branchRepository.save(existingBranch);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}

