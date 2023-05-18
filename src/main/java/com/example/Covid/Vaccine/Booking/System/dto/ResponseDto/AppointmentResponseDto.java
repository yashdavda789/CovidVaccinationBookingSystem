package com.example.Covid.Vaccine.Booking.System.dto.ResponseDto;

import com.example.Covid.Vaccine.Booking.System.Enum.DoseNo;
import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String userName;

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    CenterResponseDto centerResponseDto;

    String doctorName;

    VaccineType vaccineType;
}
