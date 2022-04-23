package com.cubicfox.repository.entity.converters;

import com.cubicfox.domain.Company;
import com.cubicfox.repository.entity.CompanyEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyToEntityConverter implements Converter<Company, CompanyEntity> {
    @Override
    public CompanyEntity convert(Company source) {
        return new CompanyEntity()
                .setName(source.getName())
                .setCatchPhrase(source.getCatchPhrase())
                .setBs(source.getBs());
    }
}
