package dev.pehlivan.airportreservationsystem.controller;

import dev.pehlivan.airportreservationsystem.model.dto.UserDataDTO;
import dev.pehlivan.airportreservationsystem.model.dto.UserLoginDTO;
import dev.pehlivan.airportreservationsystem.model.dto.UserResponseDTO;
import dev.pehlivan.airportreservationsystem.model.entity.User;

import dev.pehlivan.airportreservationsystem.service.iml.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private UserService userService;

    @PostMapping("/signin")
    public String login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.signin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserDataDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        return userService.signup(modelMapper.map(user, User.class));
    }

    @DeleteMapping(value = "/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/me")
    public UserResponseDTO whoami(HttpServletRequest req) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
    }

}