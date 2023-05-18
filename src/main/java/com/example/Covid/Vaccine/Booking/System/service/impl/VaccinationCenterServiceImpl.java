package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.CenterRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.model.VaccinationCenter;
import com.example.Covid.Vaccine.Booking.System.repository.VaccinationCenterRepository;
import com.example.Covid.Vaccine.Booking.System.service.VaccinationCenterService;
import com.example.Covid.Vaccine.Booking.System.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {

        // RequestDto -> Entity
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDtoToCenter(centerRequestDto);

        // save the center
        VaccinationCenter saveCenter = vaccinationCenterRepository.save(vaccinationCenter);

        // Entity -> ResponseDto
        return VaccinationCenterTransformer.CenterToCenterResponseDto(saveCenter);
    }
}
