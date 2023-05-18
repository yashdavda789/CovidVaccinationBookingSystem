package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import com.example.Covid.Vaccine.Booking.System.model.Dose2;
import com.example.Covid.Vaccine.Booking.System.model.User;

public interface Dose2Service {
    public Dose2 createDose2(User user, VaccineType vaccineType);
}
