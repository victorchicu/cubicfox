package com.cubicfox.repository.entity.converters;

import com.cubicfox.domain.Address;
import com.cubicfox.domain.Company;
import com.cubicfox.domain.User;
import com.cubicfox.repository.entity.AddressEntity;
import com.cubicfox.repository.entity.CompanyEntity;
import com.cubicfox.repository.entity.UserEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EntityToUserConverter implements Converter<UserEntity, User> {
    private final ConversionService conversionService;

    public EntityToUserConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public User convert(UserEntity source) {
        return new User()
                .setName(source.getName())
                .setUsername(source.getUsername())
                .setEmail(source.getEmail())
                .setAddress(toAddress(source.getAddress()))
                .setPhone(source.getPhone())
                .setWebsite(source.getWebsite())
                .setCompany(toCompany(source.getCompany()));
    }

    private Address toAddress(AddressEntity addressEntity) {
        return conversionService.convert(addressEntity, Address.class);
    }

    private Company toCompany(CompanyEntity companyEntity) {
        return conversionService.convert(companyEntity, Company.class);
    }
}
