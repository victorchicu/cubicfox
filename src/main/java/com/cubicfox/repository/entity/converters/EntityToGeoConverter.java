package com.cubicfox.repository.entity.converters;

import com.cubicfox.domain.Geo;
import com.cubicfox.repository.entity.GeoEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EntityToGeoConverter implements Converter<GeoEntity, Geo> {
    @Override
    public Geo convert(GeoEntity source) {
        return new Geo()
                .setLat(source.getLat())
                .setLng(source.getLng());
    }
}
