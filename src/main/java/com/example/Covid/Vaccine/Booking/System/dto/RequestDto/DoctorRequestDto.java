package com.example.Covid.Vaccine.Booking.System.dto.RequestDto;

import com.example.Covid.Vaccine.Booking.System.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorRequestDto {

    int centerId;

    String name;

    int age;

    String emailId;

    String mobileNo;

    Gender gender;
}
