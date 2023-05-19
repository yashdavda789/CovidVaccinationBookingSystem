package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.Enum.CenterType;
import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.CenterRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.CenterNotFoundException;
import com.example.Covid.Vaccine.Booking.System.exception.DoctorNotFoundException;

import java.util.List;

public interface VaccinationCenterService {
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto);

    List<String> getDoctorsByCenterType(String name) throws CenterNotFoundException, DoctorNotFoundException;
}
