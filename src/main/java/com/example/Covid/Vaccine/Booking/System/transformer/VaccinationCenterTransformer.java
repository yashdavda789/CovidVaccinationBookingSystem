package com.example.Covid.Vaccine.Booking.System.transformer;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.CenterRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.model.VaccinationCenter;

public class VaccinationCenterTransformer {
    public static VaccinationCenter CenterRequestDtoToCenter(CenterRequestDto centerRequestDto) {
        return VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .centerType(centerRequestDto.getCenterType())
                .build();
    }

    public static CenterResponseDto CenterToCenterResponseDto(VaccinationCenter vaccinationCenter) {
        return CenterResponseDto.builder()
                .name(vaccinationCenter.getName())
                .location(vaccinationCenter.getLocation())
                .centerType(vaccinationCenter.getCenterType())
                .build();
    }
}
