package com.example.Covid.Vaccine.Booking.System.repository;

import com.example.Covid.Vaccine.Booking.System.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
