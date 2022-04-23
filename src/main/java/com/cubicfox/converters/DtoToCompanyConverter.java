package com.cubicfox.converters;

import com.cubicfox.domain.Company;
import com.cubicfox.dto.CompanyDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToCompanyConverter implements Converter<CompanyDto, Company> {
    @Override
    public Company convert(CompanyDto source) {
        return new Company()
                .setName(source.getName())
                .setCatchPhrase(source.getCatchPhrase())
                .setBs(source.getBs());
    }
}
