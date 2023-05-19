package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.Enum.CenterType;
import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.CenterRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.CenterNotFoundException;
import com.example.Covid.Vaccine.Booking.System.exception.DoctorNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.Doctor;
import com.example.Covid.Vaccine.Booking.System.model.VaccinationCenter;
import com.example.Covid.Vaccine.Booking.System.repository.VaccinationCenterRepository;
import com.example.Covid.Vaccine.Booking.System.service.VaccinationCenterService;
import com.example.Covid.Vaccine.Booking.System.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getDoctorsByCenterType(String name) throws CenterNotFoundException, DoctorNotFoundException {
        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findByName(name);
        if(vaccinationCenter == null) {
            throw new CenterNotFoundException("Center not exist !!");
        }
        List<Doctor> doctors = vaccinationCenter.getDoctors();
        if(doctors == null) {
            throw new DoctorNotFoundException("There is no doctors in this center at this moment.");
        }

        List<String> list = new ArrayList<>();
        for(Doctor doctor : doctors) {
            list.add(doctor.getName());
        }
        return list;
    }
}
