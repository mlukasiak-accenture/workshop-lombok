package edu.workshop.lombok.boot.persistence.repositories;

import edu.workshop.lombok.boot.persistence.entities.Equity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquityRepository extends JpaRepository<Equity, Long> {

    Optional<Equity> findOneByCode(String code);
}
