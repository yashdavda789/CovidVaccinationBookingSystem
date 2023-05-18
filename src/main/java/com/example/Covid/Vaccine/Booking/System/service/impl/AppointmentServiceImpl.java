package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.Enum.DoseNo;
import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.AppointmentRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.AppointmentResponseDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.CenterResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.DoctorNotFoundException;
import com.example.Covid.Vaccine.Booking.System.exception.NotEligibleForDoseException;
import com.example.Covid.Vaccine.Booking.System.exception.UserNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.*;
import com.example.Covid.Vaccine.Booking.System.repository.DoctorRepository;
import com.example.Covid.Vaccine.Booking.System.repository.UserRepository;
import com.example.Covid.Vaccine.Booking.System.service.AppointmentService;
import com.example.Covid.Vaccine.Booking.System.service.Dose1Service;
import com.example.Covid.Vaccine.Booking.System.service.Dose2Service;
import com.example.Covid.Vaccine.Booking.System.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;
//    @Autowired
//    private JavaMailSender emailSender;

    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("User doesn't exist !!");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(!optionalDoctor.isPresent()) {
            throw new DoctorNotFoundException("Doctor doesn't exist !!");
        }

        User user = optionalUser.get();
        Doctor doctor = optionalDoctor.get();

        // Dose 1
        if(appointmentRequestDto.getDoseNo() == DoseNo.DOSE_1) {
            Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }
        // Dose 2
        else {
            if(!user.isDose1Taken()) {
                throw new NotEligibleForDoseException("Sorry! You are not eligible for dose 2");
            }
            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

        Appointment appointment = Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequestDto.getDoseNo())
                .user(user)
                .doctor(doctor)
                .build();

        user.getAppointments().add(appointment);
        User savedUser = userRepository.save(user); // save dose1, dose2 and appointment

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);

        doctor.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);

        // send mail;
//        String text = "Congrats!" + user.getName() + "Your dose " + appointmentRequestDto.getDoseNo() + "has been booked !!";
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("noreply@baeldung.com");
//        message.setTo(user.getEmailId());
//        message.setSubject("Appointment Booked !!");
//        message.setText(text);
//        emailSender.send(message);


        // create ResponseDto
        CenterResponseDto centerResponseDto = VaccinationCenterTransformer.CenterToCenterResponseDto(doctor.getVaccinationCenter());
        AppointmentResponseDto appointmentResponseDto = AppointmentResponseDto.builder()
                .userName(user.getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(savedAppointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .centerResponseDto(centerResponseDto)
                .doctorName(doctor.getName())
                .vaccineType(appointmentRequestDto.getVaccineType())
                .build();
        return appointmentResponseDto;
    }
}
