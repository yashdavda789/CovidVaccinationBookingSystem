package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.AppointmentRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.AppointmentResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.DoctorNotFoundException;
import com.example.Covid.Vaccine.Booking.System.exception.NotEligibleForDoseException;
import com.example.Covid.Vaccine.Booking.System.exception.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException;
}
