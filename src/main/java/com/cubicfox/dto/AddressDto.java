package com.cubicfox.dto;

public class AddressDto {
    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final GeoDto geo;

    public AddressDto(String street, String suite, String city, String zipcode, GeoDto geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoDto getGeo() {
        return geo;
    }
}
