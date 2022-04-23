package com.cubicfox.dto;

public class CompanyDto {
    private final String name;
    private final String catchPhrase;
    private final String bs;

    public CompanyDto(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
