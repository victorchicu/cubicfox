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
public class UserToEntityConverter implements Converter<User, UserEntity> {
    private final ConversionService conversionService;

    public UserToEntityConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public UserEntity convert(User source) {
        return new UserEntity()
                .setName(source.getName())
                .setUsername(source.getUsername())
                .setEmail(source.getEmail())
                .setAddress(toAddressEntity(source.getAddress()))
                .setPhone(source.getPhone())
                .setWebsite(source.getWebsite())
                .setCompany(toCompanyEntity(source.getCompany()));
    }

    private AddressEntity toAddressEntity(Address address) {
        return conversionService.convert(address, AddressEntity.class);
    }

    private CompanyEntity toCompanyEntity(Company company) {
        return conversionService.convert(company, CompanyEntity.class);
    }
}
