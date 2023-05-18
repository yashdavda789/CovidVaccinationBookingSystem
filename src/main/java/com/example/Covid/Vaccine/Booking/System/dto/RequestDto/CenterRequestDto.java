package com.example.Covid.Vaccine.Booking.System.dto.RequestDto;

import com.example.Covid.Vaccine.Booking.System.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterRequestDto {

    String name;

    String location;

    CenterType centerType;
}
