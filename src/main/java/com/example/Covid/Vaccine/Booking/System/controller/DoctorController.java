package com.example.Covid.Vaccine.Booking.System.controller;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.DoctorRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.DoctorResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.CenterNotFoundException;
import com.example.Covid.Vaccine.Booking.System.exception.DoctorNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.Appointment;
import com.example.Covid.Vaccine.Booking.System.model.Doctor;
import com.example.Covid.Vaccine.Booking.System.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        }
        catch (CenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getDoctor")
    public ResponseEntity getDoctorByAge(@RequestParam int age) {
        try {
            List<String> doctors = doctorService.getDoctorByAgeGreaterThan(age);
            return new ResponseEntity(doctors, HttpStatus.FOUND);
        }
        catch (DoctorNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAppointment")
    public ResponseEntity getAppointmentList(@RequestParam("name") String name) {
        try {
            int appointments = doctorService.getAppointments(name);
            return new ResponseEntity(appointments, HttpStatus.FOUND);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
