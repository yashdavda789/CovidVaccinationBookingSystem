package com.example.Covid.Vaccine.Booking.System.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDto {

    String name;

    String emailId;

    String mobileNo;

    CenterResponseDto centerResponseDto;
}
