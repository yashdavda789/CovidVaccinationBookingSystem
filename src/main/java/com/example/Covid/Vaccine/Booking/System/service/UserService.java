package com.example.Covid.Vaccine.Booking.System.service;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.UserRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.UserResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.UserNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.User;

import java.util.List;

public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);

    UserResponseDto findByEmail(String emailId) throws UserNotFoundException;

    List<String> getAllUserNotTakenSingleDose();

    String updateMobileNo(String name, String mobileNo) throws UserNotFoundException;
}
