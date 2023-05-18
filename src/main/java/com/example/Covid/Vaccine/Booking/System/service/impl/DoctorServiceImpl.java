package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.DoctorRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.DoctorResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.CenterNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.Doctor;
import com.example.Covid.Vaccine.Booking.System.model.VaccinationCenter;
import com.example.Covid.Vaccine.Booking.System.repository.DoctorRepository;
import com.example.Covid.Vaccine.Booking.System.repository.VaccinationCenterRepository;
import com.example.Covid.Vaccine.Booking.System.service.DoctorService;
import com.example.Covid.Vaccine.Booking.System.transformer.DoctorTransformer;
import com.example.Covid.Vaccine.Booking.System.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotFoundException {

        Optional<VaccinationCenter> optionalCenter = vaccinationCenterRepository.findById(doctorRequestDto.getCenterId());
        if(!optionalCenter.isPresent()) {
            throw new CenterNotFoundException("Invalid center id !!");
        }
        VaccinationCenter vaccinationCenter = optionalCenter.get();

        // RequestDto -> Entity
        Doctor doctor = DoctorTransformer.DoctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setVaccinationCenter(vaccinationCenter);

        // add doctor to current list of doctors at that center
        vaccinationCenter.getDoctors().add(doctor);

        // saved both center and doctor
        VaccinationCenter savedCenter = vaccinationCenterRepository.save(vaccinationCenter);

        // ResponseDto -> Entity
        return DoctorTransformer.DoctorToDoctorResponseDto(doctor);
    }
}
