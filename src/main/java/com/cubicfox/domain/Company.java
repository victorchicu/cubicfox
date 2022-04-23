package com.cubicfox.domain;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public Company setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
        return this;
    }

    public String getBs() {
        return bs;
    }

    public Company setBs(String bs) {
        this.bs = bs;
        return this;
    }
}
