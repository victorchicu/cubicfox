package com.cubicfox.repository.entity;


import javax.persistence.*;

@Entity
@Table(name = UserEntity.COLUMN_NAME, schema = "cubicfox")
public class UserEntity {
    public static final String COLUMN_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
//    @PrimaryKeyJoinColumn
    private AddressEntity address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website")
    private String website;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
//    @PrimaryKeyJoinColumn
    private CompanyEntity company;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public UserEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public UserEntity setWebsite(String website) {
        this.website = website;
        return this;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public UserEntity setCompany(CompanyEntity company) {
        this.company = company;
        return this;
    }
}
