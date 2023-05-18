package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import com.example.Covid.Vaccine.Booking.System.model.Dose1;
import com.example.Covid.Vaccine.Booking.System.model.User;

public interface Dose1Service {
    public Dose1 createDose1(User user, VaccineType vaccineType);
}
