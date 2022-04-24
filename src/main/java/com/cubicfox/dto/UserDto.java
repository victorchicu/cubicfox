package com.cubicfox.dto;

import com.cubicfox.validators.Email;

public class UserDto {
    private final Long id;
    private final String name;
    private final String username;
    @Email
    private final String email;
    private final AddressDto address;
    private final String phone;
    private final String website;
    private final CompanyDto company;

    public UserDto(
            Long id,
            String name,
            String username,
            String email,
            AddressDto address,
            String phone,
            String website,
            CompanyDto company
    ) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public CompanyDto getCompany() {
        return company;
    }
}
