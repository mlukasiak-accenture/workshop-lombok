package edu.workshop.lombok.boot.persistence.entities;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Set;

@Slf4j
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private Set<Holding> holdings;
    private BigDecimal cashAmount;

}
