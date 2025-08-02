package ai.cargopro.dto;

import ai.cargopro.entity.Facility;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
public class LoadDto {
    private UUID shipperId;
    private Facility facility;
    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private Double weight;
    private String comment;
    private Instant datePosted;
}
