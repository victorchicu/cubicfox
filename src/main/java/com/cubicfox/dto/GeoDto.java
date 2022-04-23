package com.cubicfox.dto;

import java.math.BigDecimal;

public class GeoDto {
    private final BigDecimal lat;
    private final BigDecimal lng;

    public GeoDto(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLng() {
        return lng;
    }
}
