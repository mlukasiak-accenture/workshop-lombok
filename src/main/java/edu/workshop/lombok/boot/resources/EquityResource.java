package edu.workshop.lombok.boot.resources;

import edu.workshop.lombok.boot.model.EquityDTO;
import edu.workshop.lombok.boot.services.EquityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "equities")
public class EquityResource {
    private final EquityService equityService;

    public EquityResource(EquityService equityService) {
        this.equityService = equityService;
    }

    @PostMapping
    public EquityDTO createEquity(@RequestBody EquityDTO equityDTO) {
        return equityService.createEquity(equityDTO);
    }

    @GetMapping
    public List<EquityDTO> getAllEquities() {
        return equityService.getAll();
    }

    @GetMapping(path = "/{code}")
    public EquityDTO getByCode(@PathVariable String code) {
        return equityService.getByCode(code);
    }
}
