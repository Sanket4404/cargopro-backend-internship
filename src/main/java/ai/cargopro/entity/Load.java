package ai.cargopro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class Load {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID shipperId;

    @Embedded
    private Facility facility = new Facility();

    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private Double weight;
    private String comment;

    private Instant datePosted;

    @Enumerated(EnumType.STRING)
    private LoadStatus status = LoadStatus.POSTED;
}
