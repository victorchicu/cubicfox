package com.cubicfox.converters;

import com.cubicfox.domain.Address;
import com.cubicfox.domain.Company;
import com.cubicfox.domain.User;
import com.cubicfox.dto.AddressDto;
import com.cubicfox.dto.CompanyDto;
import com.cubicfox.dto.UserDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToUserConverter implements Converter<UserDto, User> {
    private final ConversionService conversionService;

    public DtoToUserConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public User convert(UserDto source) {
        return new User()
                .setName(source.getName())
                .setUsername(source.getUsername())
                .setEmail(source.getEmail())
                .setAddress(toAddress(source.getAddress()))
                .setPhone(source.getPhone())
                .setWebsite(source.getWebsite())
                .setCompany(toCompany(source.getCompany()));
    }

    private Address toAddress(AddressDto addressDto) {
        return conversionService.convert(addressDto, Address.class);
    }

    private Company toCompany(CompanyDto companyDto) {
        return conversionService.convert(companyDto, Company.class);
    }
}
