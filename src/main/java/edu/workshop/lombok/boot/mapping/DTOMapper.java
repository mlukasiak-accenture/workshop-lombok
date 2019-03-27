package edu.workshop.lombok.boot.mapping;

import edu.workshop.lombok.boot.model.EquityDTO;
import edu.workshop.lombok.boot.persistence.entities.Equity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    EquityDTO equityToDTO(Equity equity);

    Equity dtoToEquity(EquityDTO equityDTO);

    List<EquityDTO> equitiesToDTO(List<Equity> equities);
}
