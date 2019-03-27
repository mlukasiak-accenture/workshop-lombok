package edu.workshop.lombok.boot.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EquityDTO {
    private String name;
    private String isin;
    private String code;
    private String currencyCode;
    private long shares;
}
