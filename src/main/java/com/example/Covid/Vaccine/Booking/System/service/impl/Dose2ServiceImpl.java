package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import com.example.Covid.Vaccine.Booking.System.model.Dose1;
import com.example.Covid.Vaccine.Booking.System.model.Dose2;
import com.example.Covid.Vaccine.Booking.System.model.User;
import com.example.Covid.Vaccine.Booking.System.service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {
        Dose2 dose2 = Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
        return dose2;
    }
}
