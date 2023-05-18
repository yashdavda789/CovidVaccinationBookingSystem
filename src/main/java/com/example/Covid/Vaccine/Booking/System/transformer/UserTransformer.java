package com.example.Covid.Vaccine.Booking.System.transformer;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.UserRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.UserResponseDto;
import com.example.Covid.Vaccine.Booking.System.model.User;
public class UserTransformer {
    public static User userRequestDtoToUser(UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .emailId(userRequestDto.getEmailId())
                .gender(userRequestDto.getGender())
                .mobileNo(userRequestDto.getMobileNo())
                .build();
    }

    public static UserResponseDto userToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .name(user.getName())
                .message("Congrats ! You have register on Covid Vaccination")
                .build();
    }
}
