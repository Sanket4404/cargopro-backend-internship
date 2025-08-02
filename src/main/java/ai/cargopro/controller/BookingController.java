package ai.cargopro.controller;

import ai.cargopro.dto.BookingDto;
import ai.cargopro.entity.Booking;
import ai.cargopro.service.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService service;
    public BookingController(BookingService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingDto dto) {
        return ResponseEntity.ok(service.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<Page<Booking>> list(
            @RequestParam(required = false) UUID loadId,
            @RequestParam(required = false) UUID transporterId,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.find(loadId, transporterId, status, page, size));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> one(@PathVariable UUID bookingId) {
        return ResponseEntity.ok(service.get(bookingId));
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> update(@PathVariable UUID bookingId, @RequestBody BookingDto dto) {
        return ResponseEntity.ok(service.update(bookingId, dto));
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> delete(@PathVariable UUID bookingId) {
        service.delete(bookingId);
        return ResponseEntity.noContent().build();
    }
}
