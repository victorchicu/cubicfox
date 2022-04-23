package com.cubicfox.domain;

import java.math.BigDecimal;

public class Geo {
    private BigDecimal lat;
    private BigDecimal lng;

    public BigDecimal getLat() {
        return lat;
    }

    public Geo setLat(BigDecimal lat) {
        this.lat = lat;
        return this;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public Geo setLng(BigDecimal lng) {
        this.lng = lng;
        return this;
    }
}
