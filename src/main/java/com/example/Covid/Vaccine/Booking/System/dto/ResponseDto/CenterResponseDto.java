package com.example.Covid.Vaccine.Booking.System.dto.ResponseDto;

import com.example.Covid.Vaccine.Booking.System.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponseDto {

    String name;

    String location;

    CenterType centerType;
}
