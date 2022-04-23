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
public class AddressToDtoConverter implements Converter<Address, AddressDto> {
    private final ConversionService conversionService;

    public AddressToDtoConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public AddressDto convert(Address source) {
        return new AddressDto(
                source.getStreet(),
                source.getSuite(),
                source.getCity(),
                source.getZipcode(),
                toGeoDto(source.getGeo())
        );
    }

    private GeoDto toGeoDto(Geo geo) {
        return conversionService.convert(geo, GeoDto.class);
    }

}
