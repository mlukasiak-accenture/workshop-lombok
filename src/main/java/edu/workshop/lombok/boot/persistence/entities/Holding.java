package edu.workshop.lombok.boot.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Holding {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private Equity equity;

}
