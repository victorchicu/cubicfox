package com.cubicfox.services.impl;

import com.cubicfox.domain.User;
import com.cubicfox.repository.entity.UserEntity;
import com.cubicfox.repository.UserRepository;
import com.cubicfox.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public User saveOrUpdate(User user) {
        UserEntity userEntity = toUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return toUser(userEntity);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users.stream()
                .map(this::toUserEntity)
                .collect(Collectors.toList())
        );
    }

    @Override
    public List<User> findAll() {
        return Streamable.of(userRepository.findAll())
                .map(this::toUser)
                .toList();
    }

    private User toUser(UserEntity userEntity) {
        return conversionService.convert(userEntity, User.class);
    }

    private UserEntity toUserEntity(User user) {
        return conversionService.convert(user, UserEntity.class);
    }
}
