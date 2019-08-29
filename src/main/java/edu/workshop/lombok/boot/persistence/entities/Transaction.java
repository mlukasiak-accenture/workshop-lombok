package edu.workshop.lombok.boot.persistence.entities;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Slf4j
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

}
