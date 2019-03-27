package edu.workshop.lombok.boot.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Equity {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="ISIN")
    private String isin;

    @Column(name="CODE", unique = true)
    private String code;

    @Column(name="CURRENCY_CODE")
    @Enumerated(value = EnumType.STRING)
    private CurrencyCode currencyCode;

    @Column(name="MARKET_SHARES")
    private long shares;
}
