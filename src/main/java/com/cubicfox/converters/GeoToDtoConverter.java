package com.cubicfox.converters;

import com.cubicfox.domain.Geo;
import com.cubicfox.dto.GeoDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GeoToDtoConverter implements Converter<Geo, GeoDto> {
    @Override
    public GeoDto convert(Geo source) {
        return new GeoDto(source.getLat(), source.getLng());
    }
}
