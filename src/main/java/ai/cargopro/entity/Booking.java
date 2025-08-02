package ai.cargopro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID loadId;
    private UUID transporterId;
    private Double proposedRate;
    private String comment;

    private Instant requestedAt;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;
}
