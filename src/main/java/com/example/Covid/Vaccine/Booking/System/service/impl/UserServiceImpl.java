package com.example.Covid.Vaccine.Booking.System.service.impl;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.UserRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.UserResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.UserNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.User;
import com.example.Covid.Vaccine.Booking.System.repository.UserRepository;
import com.example.Covid.Vaccine.Booking.System.service.UserService;
import com.example.Covid.Vaccine.Booking.System.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public UserResponseDto findByEmail(String emailId) throws UserNotFoundException {
        User user = userRepository.findByEmailId(emailId);
        if(user == null) {
            throw new UserNotFoundException("User not exist");
        }

        UserResponseDto userResponseDto = UserTransformer.userToUserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public List<String> getAllUserNotTakenSingleDose() {
        List<User> users = userRepository.findAll();
        List<String> names = new ArrayList<>();
        for(User user : users) {
            if(!user.isDose1Taken() && !user.isDose2Taken()) {
                names.add(user.getName());
            }
        }
        return names;
    }

    @Override
    public String updateMobileNo(String name, String mobileNo) throws UserNotFoundException {
        User user = userRepository.findByName(name);
        if(user == null) {
            throw new UserNotFoundException("User not exist !!");
        }
        user.setMobileNo(mobileNo);
        userRepository.save(user);
        return user.getName() + " number updated successfully !!";
    }
}
