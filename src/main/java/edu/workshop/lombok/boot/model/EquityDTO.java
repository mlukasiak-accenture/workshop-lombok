package edu.workshop.lombok.boot.model;

import java.util.Objects;

public class EquityDTO {
    private String name;
    private String isin;
    private String code;
    private String currencyCode;
    private long shares;

    public String getName() {
        return name;
    }

    public String getIsin() {
        return isin;
    }

    public String getCode() {
        return code;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public long getShares() {
        return shares;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setShares(long shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "EquityDTO{" +
                "name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", code='" + code + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", shares=" + shares +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquityDTO equityDTO = (EquityDTO) o;
        return Objects.equals(getIsin(), equityDTO.getIsin()) &&
                getCode().equals(equityDTO.getCode()) &&
                getCurrencyCode().equals(equityDTO.getCurrencyCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsin(), getCode(), getCurrencyCode());
    }
}
