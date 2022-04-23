package com.cubicfox.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "geo")
public class GeoEntity {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name = "lat")
    private BigDecimal lat;
    @Column(name = "lng")
    private BigDecimal lng;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public GeoEntity setLat(BigDecimal lat) {
        this.lat = lat;
        return this;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public GeoEntity setLng(BigDecimal lng) {
        this.lng = lng;
        return this;
    }
}
