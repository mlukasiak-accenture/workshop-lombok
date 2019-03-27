package edu.workshop.lombok.boot.services;

import edu.workshop.lombok.boot.exceptions.DuplicateEntryException;
import edu.workshop.lombok.boot.exceptions.NotFoundException;
import edu.workshop.lombok.boot.mapping.DTOMapper;
import edu.workshop.lombok.boot.model.EquityDTO;
import edu.workshop.lombok.boot.persistence.entities.Equity;
import edu.workshop.lombok.boot.persistence.repositories.EquityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquityService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EquityService.class);

    private final EquityRepository equityRepository;
    private final DTOMapper dtoMapper;

    public EquityService(EquityRepository equityRepository, DTOMapper dtoMapper) {
        this.equityRepository = equityRepository;
        this.dtoMapper = dtoMapper;
    }

    public EquityDTO createEquity(EquityDTO equityDTO) {
        if (equityDTO == null) {
            throw new NullPointerException("Equity cannot be null.");
        }
        log.info("Checking if equity already present for code {}", equityDTO.getCode());
        Optional<Equity> existingEquity = equityRepository.findOneByCode(equityDTO.getCode());
        if (!existingEquity.isPresent()) {
            log.info("Equity does not exist. Creating equity: {}", equityDTO);
            Equity newEquity = dtoMapper.dtoToEquity(equityDTO);
            newEquity = equityRepository.save(newEquity);
            log.info("Equity saved with id: {}", newEquity.getId());
            return dtoMapper.equityToDTO(newEquity);
        } else {
            log.error("Equity with code {} already exists.", equityDTO.getCode());
            throw new DuplicateEntryException(Equity.class, equityDTO.getCode());
        }
    }

    public List<EquityDTO> getAll() {
        return dtoMapper.equitiesToDTO(equityRepository.findAll());
    }

    public EquityDTO getByCode(String code) {
        Equity equity = equityRepository.findOneByCode(code).orElseThrow(() -> new NotFoundException(Equity.class, code));
        return dtoMapper.equityToDTO(equity);
    }
}
