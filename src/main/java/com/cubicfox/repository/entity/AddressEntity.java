package com.cubicfox.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = AddressEntity.COLUMN_NAME, schema = "cubicfox")
public class AddressEntity {
    public static final String COLUMN_NAME = "address";

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "suite")
    private String suite;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
//    @PrimaryKeyJoinColumn
    private GeoEntity geo;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private UserEntity user;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public AddressEntity setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getSuite() {
        return suite;
    }

    public AddressEntity setSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public AddressEntity setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public GeoEntity getGeo() {
        return geo;
    }

    public AddressEntity setGeo(GeoEntity geo) {
        this.geo = geo;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
