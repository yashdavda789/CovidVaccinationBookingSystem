package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.DoctorRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.DoctorResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.CenterNotFoundException;
import com.example.Covid.Vaccine.Booking.System.exception.DoctorNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.Doctor;

import java.util.List;

public interface DoctorService {
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotFoundException;

    List<String> getDoctorByAgeGreaterThan(int age) throws DoctorNotFoundException;

    int getAppointments(String name) throws DoctorNotFoundException;
}
