package com.cubicfox.converters;

import com.cubicfox.domain.Company;
import com.cubicfox.dto.CompanyDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyToDtoConverter implements Converter<Company, CompanyDto> {
    @Override
    public CompanyDto convert(Company source) {
        return new CompanyDto(
                source.getName(),
                source.getCatchPhrase(),
                source.getBs()
        );
    }
}
