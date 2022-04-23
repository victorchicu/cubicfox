package com.cubicfox.repository.entity.converters;

import com.cubicfox.domain.Company;
import com.cubicfox.repository.entity.CompanyEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EntityToCompanyConverter implements Converter<CompanyEntity, Company> {
    @Override
    public Company convert(CompanyEntity source) {
        return new Company()
                .setName(source.getName())
                .setCatchPhrase(source.getCatchPhrase())
                .setBs(source.getBs());
    }
}
