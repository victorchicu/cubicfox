package com.cubicfox.converters;

import com.cubicfox.domain.Address;
import com.cubicfox.domain.Geo;
import com.cubicfox.dto.AddressDto;
import com.cubicfox.dto.GeoDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToAddressConverter implements Converter<AddressDto, Address> {
    private final ConversionService conversionService;

    public DtoToAddressConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Address convert(AddressDto source) {
        return new Address()
                .setStreet(source.getStreet())
                .setSuite(source.getSuite())
                .setCity(source.getCity())
                .setZipcode(source.getZipcode())
                .setGeo(toGeo(source.getGeo()));
    }

    private Geo toGeo(GeoDto geoDto) {
        return conversionService.convert(geoDto, Geo.class);
    }
}
