package com.cubicfox.repository.entity.converters;

import com.cubicfox.domain.Geo;
import com.cubicfox.repository.entity.GeoEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GeoToEntityConverter implements Converter<Geo, GeoEntity> {
    @Override
    public GeoEntity convert(Geo source) {
        return new GeoEntity()
                .setLat(source.getLat())
                .setLng(source.getLng());
    }
}
