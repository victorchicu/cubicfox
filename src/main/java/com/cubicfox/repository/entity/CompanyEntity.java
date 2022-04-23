package com.cubicfox.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "catchPhrase")
    private String catchPhrase;
    @Column(name = "bs")
    private String bs;

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
}
