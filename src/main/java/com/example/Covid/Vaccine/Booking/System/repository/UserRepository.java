package com.example.Covid.Vaccine.Booking.System.repository;

import com.example.Covid.Vaccine.Booking.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
