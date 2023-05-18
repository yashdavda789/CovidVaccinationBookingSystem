package com.example.Covid.Vaccine.Booking.System.transformer;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.DoctorRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.DoctorResponseDto;
import com.example.Covid.Vaccine.Booking.System.model.Doctor;
import com.example.Covid.Vaccine.Booking.System.model.VaccinationCenter;

import javax.print.Doc;

public class DoctorTransformer {
    public static Doctor DoctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto) {
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .emailId(doctorRequestDto.getEmailId())
                .mobilNo(doctorRequestDto.getMobileNo())
                .gender(doctorRequestDto.getGender())
                .build();
    }

    public static DoctorResponseDto DoctorToDoctorResponseDto(Doctor doctor) {
        CenterResponseDto centerResponseDto = VaccinationCenterTransformer.CenterToCenterResponseDto(doctor.getVaccinationCenter());
        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobileNo(doctor.getMobilNo())
                .centerResponseDto(centerResponseDto)
                .build();
    }
}
