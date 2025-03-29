package com.example.webmakeup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webmakeup.models.*;

import java.util.List;

public class WebMakeupRepositories {

    @Repository
    public interface ShopOwnerRepository extends JpaRepository<ShopOwner, Long> {
        ShopOwner findByUsername(String username);
    }

    @Repository
    public interface BranchManagerRepository extends JpaRepository<BranchManager, Long> {
        List<BranchManager> findByBranchId(Long branchId);
    }

    @Repository
    public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
        List<Receptionist> findByBranchId(Long branchId);
    }

    @Repository
    public interface MakeupArtistRepository extends JpaRepository<MakeupArtist, Long> {
        List<MakeupArtist> findByBranchId(Long branchId);
        List<MakeupArtist> findByAvailableTrue();
    }

    @Repository
    public interface CustomerRepository extends JpaRepository<Customer, Long> {
        Customer findByEmail(String email);
    }

    @Repository
    public interface BookingRepository extends JpaRepository<Booking, Long> {
        List<Booking> findByCustomerId(Long customerId);
        List<Booking> findByBranchId(Long branchId);
        List<Booking> findByMakeupArtistId(Long artistId);
    }

    @Repository
    public interface ServiceRepository extends JpaRepository<Service, Long> {
        List<Service> findByBranchId(Long branchId);
    }

    @Repository
    public interface PromotionRepository extends JpaRepository<Promotion, Long> {
        List<Promotion> findByActiveTrue();
    }
}
