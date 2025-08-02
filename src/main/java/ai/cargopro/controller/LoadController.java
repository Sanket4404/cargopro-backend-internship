package ai.cargopro.controller;

import ai.cargopro.dto.LoadDto;
import ai.cargopro.entity.Load;
import ai.cargopro.service.LoadService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/load")
public class LoadController {
    private final LoadService service;
    public LoadController(LoadService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Load> create(@RequestBody LoadDto dto) {
        return ResponseEntity.ok(service.createLoad(dto));
    }

    @GetMapping
    public ResponseEntity<Page<Load>> list(
            @RequestParam(required = false) UUID shipperId,
            @RequestParam(required = false) String truckType,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.find(shipperId, truckType, status, page, size));
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> one(@PathVariable UUID loadId) {
        return ResponseEntity.ok(service.get(loadId));
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> update(@PathVariable UUID loadId, @RequestBody LoadDto dto) {
        return ResponseEntity.ok(service.update(loadId, dto));
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> delete(@PathVariable UUID loadId) {
        service.delete(loadId);
        return ResponseEntity.noContent().build();
    }
}
