package com.example.Covid.Vaccine.Booking.System.repository;

import com.example.Covid.Vaccine.Booking.System.model.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dose1Repository extends JpaRepository<Dose1, Integer> {
}
