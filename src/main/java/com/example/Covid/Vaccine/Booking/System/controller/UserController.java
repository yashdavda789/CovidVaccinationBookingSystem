package com.example.Covid.Vaccine.Booking.System.controller;

import com.example.Covid.Vaccine.Booking.System.dto.RequestDto.UserRequestDto;
import com.example.Covid.Vaccine.Booking.System.dto.ResponseDto.UserResponseDto;
import com.example.Covid.Vaccine.Booking.System.exception.UserNotFoundException;
import com.example.Covid.Vaccine.Booking.System.model.User;
import com.example.Covid.Vaccine.Booking.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/find-by-email")
    public ResponseEntity findByEmailId(@RequestParam("emailId") String emailId) {
        try {
            UserResponseDto userResponseDto = userService.findByEmail(emailId);
            return new ResponseEntity(userResponseDto, HttpStatus.FOUND);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/without-dose")
    public ResponseEntity getAllUserNotTakenSingleDose() {
        List<String> names = userService.getAllUserNotTakenSingleDose();
        return new ResponseEntity(names, HttpStatus.FOUND);
    }

    @PutMapping("/update-mobNo")
    public ResponseEntity updateMobileNo(@RequestParam("name") String name, @RequestParam("mobileNo") String mobileNo) {
        try {
            String ans = userService.updateMobileNo(name, mobileNo);
            return new ResponseEntity(ans, HttpStatus.CREATED);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
