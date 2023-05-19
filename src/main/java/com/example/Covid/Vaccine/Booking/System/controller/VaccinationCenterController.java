package com.example.Covid.Vaccine.Booking.System.controller;

import com.example.Covid.Vaccine.Booking.System.Enum.CenterType;
import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.CenterRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.model.VaccinationCenter;
import com.example.Covid.Vaccine.Booking.System.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto) {
        CenterResponseDto centerResponseDto = vaccinationCenterService.addCenter(centerRequestDto);
        return new ResponseEntity(centerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get-doctors-by-center")
    public ResponseEntity getDoctorsByCenter(@RequestParam("name") String name) {
        try {
            List<String> doctors = vaccinationCenterService.getDoctorsByCenterType(name);
            return new ResponseEntity(doctors, HttpStatus.FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
