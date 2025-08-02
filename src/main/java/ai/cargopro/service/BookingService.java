package ai.cargopro.service;

import ai.cargopro.dto.BookingDto;
import ai.cargopro.entity.Booking;
import ai.cargopro.entity.BookingStatus;
import ai.cargopro.repository.BookingRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Booking createBooking(BookingDto dto) {
        Booking b = new Booking();
        b.setLoadId(dto.getLoadId());
        b.setTransporterId(dto.getTransporterId());
        b.setProposedRate(dto.getProposedRate());
        b.setComment(dto.getComment());
        b.setStatus(BookingStatus.PENDING);
        return repo.save(b);
    }

    public Page<Booking> find(UUID loadId, UUID transporterId, String status, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable); // simple; refine with specs later
    }

    public Booking get(UUID id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Transactional
    public Booking update(UUID id, BookingDto dto) {
        Booking b = get(id);
        b.setProposedRate(dto.getProposedRate());
        b.setComment(dto.getComment());
        return repo.save(b);
    }

    @Transactional
    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
