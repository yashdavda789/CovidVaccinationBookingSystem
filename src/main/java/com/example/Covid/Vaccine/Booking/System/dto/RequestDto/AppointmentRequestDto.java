package com.example.Covid.Vaccine.Booking.System.dto.RequestDto;

import com.example.Covid.Vaccine.Booking.System.Enum.DoseNo;
import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {

    DoseNo doseNo;

    int userId;

    int doctorId;

    VaccineType vaccineType;
}
