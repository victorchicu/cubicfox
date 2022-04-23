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
public class UserToDtoConverter implements Converter<User, UserDto> {
    private final ConversionService conversionService;

    public UserToDtoConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public UserDto convert(User source) {
        return new UserDto(
                source.getName(),
                source.getUsername(),
                source.getEmail(),
                toAddressDto(source.getAddress()),
                source.getPhone(),
                source.getWebsite(),
                toCompanyDto(source.getCompany())
        );
    }

    private AddressDto toAddressDto(Address address) {
        return conversionService.convert(address, AddressDto.class);
    }

    private CompanyDto toCompanyDto(Company company) {
        return conversionService.convert(company, CompanyDto.class);
    }
}
