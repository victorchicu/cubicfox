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
public class EntityToAddressConverter implements Converter<AddressEntity, Address> {
    private final ConversionService conversionService;

    public EntityToAddressConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Address convert(AddressEntity source) {
        return new Address()
                .setStreet(source.getStreet())
                .setSuite(source.getSuite())
                .setCity(source.getCity())
                .setZipcode(source.getZipcode())
                .setGeo(toGeo(source.getGeo()));
    }

    private Geo toGeo(GeoEntity geoEntity) {
        return conversionService.convert(geoEntity, Geo.class);
    }
}
