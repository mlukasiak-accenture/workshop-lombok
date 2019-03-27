package edu.workshop.lombok.boot.services;

import edu.workshop.lombok.boot.exceptions.DuplicateEntryException;
import edu.workshop.lombok.boot.exceptions.NotFoundException;
import edu.workshop.lombok.boot.mapping.DTOMapper;
import edu.workshop.lombok.boot.model.EquityDTO;
import edu.workshop.lombok.boot.persistence.entities.Equity;
import edu.workshop.lombok.boot.persistence.repositories.EquityRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EquityService {
    private final EquityRepository equityRepository;
    private final DTOMapper dtoMapper;

    public EquityDTO createEquity(@NonNull EquityDTO equityDTO) {
        log.info("Checking if equity already present for code {}", equityDTO.getCode());
        val existingEquity = equityRepository.findOneByCode(equityDTO.getCode());
        if (!existingEquity.isPresent()) {
            log.info("Equity does not exist. Creating equity: {}", equityDTO);
            var newEquity = dtoMapper.dtoToEquity(equityDTO);
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
        val equity = equityRepository.findOneByCode(code).orElseThrow(() -> new NotFoundException(Equity.class, code));
        return dtoMapper.equityToDTO(equity);
    }
}
