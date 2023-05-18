package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.UserRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.UserResponseDto;
import com.example.Covid.Vaccine.Booking.System.model.User;
import com.example.Covid.Vaccine.Booking.System.repository.UserRepository;
import com.example.Covid.Vaccine.Booking.System.service.UserService;
import com.example.Covid.Vaccine.Booking.System.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        // RequestDto -> Entity
        User user = UserTransformer.userRequestDtoToUser(userRequestDto);

        // save the user
        User saveUser = userRepository.save(user);

        // Entity -> ResponseDto
        UserResponseDto userResponseDto = UserTransformer.userToUserResponseDto(saveUser);

        return userResponseDto;
    }
}
