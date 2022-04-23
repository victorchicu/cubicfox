package com.cubicfox.converters;

import com.cubicfox.domain.Geo;
import com.cubicfox.dto.GeoDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToGeoConverter implements Converter<GeoDto, Geo> {
    @Override
    public Geo convert(GeoDto source) {
        return new Geo()
                .setLat(source.getLat())
                .setLng(source.getLng());
    }
}
