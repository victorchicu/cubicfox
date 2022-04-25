package com.cubicfox.controllers;

import com.cubicfox.domain.User;
import com.cubicfox.dto.UserDto;
import com.cubicfox.feigns.UserClient;
import com.cubicfox.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Validated
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
    public List<@Valid UserDto> listUsers() {
        return userClient.listUsers();
    }

    @PostMapping
    public void saveAll(@Valid @RequestBody @NotEmpty List<UserDto> users) {
        userService.saveAll(users.stream()
                .map(this::toUser)
                .collect(Collectors.toList())
        );
    }

    private User toUser(UserDto userDto) {
        return conversionService.convert(userDto, User.class);
    }

    private UserDto toUserDto(User user) {
        return conversionService.convert(user, UserDto.class);
    }
}
