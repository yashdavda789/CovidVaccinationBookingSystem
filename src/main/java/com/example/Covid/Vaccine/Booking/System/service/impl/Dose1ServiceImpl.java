package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import com.example.Covid.Vaccine.Booking.System.model.Dose1;
import com.example.Covid.Vaccine.Booking.System.model.User;
import com.example.Covid.Vaccine.Booking.System.service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {
    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {
        Dose1 dose1 = Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
        return dose1;
    }
}
