package com.cubicfox.services.impl;

import com.cubicfox.domain.User;
import com.cubicfox.repository.entity.UserEntity;
import com.cubicfox.repository.UserRepository;
import com.cubicfox.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = toUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return toUser(userEntity);
    }

    private User toUser(UserEntity userEntity) {
        return conversionService.convert(userEntity, User.class);
    }

    private UserEntity toUserEntity(User user) {
        return conversionService.convert(user, UserEntity.class);
    }
}
