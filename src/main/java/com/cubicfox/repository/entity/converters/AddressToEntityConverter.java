package com.cubicfox.repository.entity.converters;

import com.cubicfox.domain.Address;
import com.cubicfox.domain.Geo;
import com.cubicfox.repository.entity.AddressEntity;
import com.cubicfox.repository.entity.GeoEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToEntityConverter implements Converter<Address, AddressEntity> {
    private final ConversionService conversionService;

    public AddressToEntityConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public AddressEntity convert(Address source) {
        return new AddressEntity()
                .setStreet(source.getStreet())
                .setSuite(source.getSuite())
                .setCity(source.getCity())
                .setZipcode(source.getZipcode())
                .setGeo(toGeoEntity(source.getGeo()));
    }

    private GeoEntity toGeoEntity(Geo geo) {
        return conversionService.convert(geo, GeoEntity.class);
    }
}
