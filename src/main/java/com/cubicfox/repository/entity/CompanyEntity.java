package com.cubicfox.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "company", schema = "cubicfox")
public class CompanyEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "catchPhrase")
    private String catchPhrase;
    @Column(name = "bs")
    private String bs;
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

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public CompanyEntity setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
        return this;
    }

    public String getBs() {
        return bs;
    }

    public CompanyEntity setBs(String bs) {
        this.bs = bs;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
