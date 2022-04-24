package com.cubicfox.repository.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = GeoEntity.COLUMN_NAME, schema = "cubicfox")
public class GeoEntity {
    public static final String COLUMN_NAME = "geo";

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "lat")
    private BigDecimal lat;
    @Column(name = "lng")
    private BigDecimal lng;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private AddressEntity address;

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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
