package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.CenterRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;

public interface VaccinationCenterService {
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto);
}
