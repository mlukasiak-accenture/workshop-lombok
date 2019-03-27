package edu.workshop.lombok.boot.persistence.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Equity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ISIN")
    private String isin;

    @Column(name = "CODE", unique = true)
    private String code;

    @Column(name = "CURRENCY_CODE")
    @Enumerated(value = EnumType.STRING)
    private CurrencyCode currencyCode;

    @Column(name = "MARKET_SHARES")
    private long shares;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public long getShares() {
        return shares;
    }

    public void setShares(long shares) {
        this.shares = shares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equity equity = (Equity) o;
        return getShares() == equity.getShares() &&
                Objects.equals(getName(), equity.getName()) &&
                Objects.equals(getIsin(), equity.getIsin()) &&
                Objects.equals(getCode(), equity.getCode()) &&
                getCurrencyCode() == equity.getCurrencyCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIsin(), getCode(), getCurrencyCode(), getShares());
    }

    @Override
    public String toString() {
        return "Equity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", code='" + code + '\'' +
                ", currencyCode=" + currencyCode +
                ", shares=" + shares +
                '}';
    }
}
