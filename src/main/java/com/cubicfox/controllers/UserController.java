package com.cubicfox.controllers;

import com.cubicfox.domain.User;
import com.cubicfox.dto.UserDto;
import com.cubicfox.feigns.UserClient;
import com.cubicfox.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserClient userClient;
    private final UserService userService;
    private final ConversionService conversionService;

    public UserController(UserClient userClient, UserService userService, ConversionService conversionService) {
        this.userClient = userClient;
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<UserDto> listUsers() {
        return userClient.listUsers().stream()
                .map(userDto -> {
                    return userService.save(toUser(userDto));
                })
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    private User toUser(UserDto userDto) {
        return conversionService.convert(userDto, User.class);
    }

    private UserDto toUserDto(User user) {
        return conversionService.convert(user, UserDto.class);
    }
}
