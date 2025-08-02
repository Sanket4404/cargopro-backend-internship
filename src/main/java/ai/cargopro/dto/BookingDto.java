package ai.cargopro.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class BookingDto {
    private UUID loadId;
    private UUID transporterId;
    private Double proposedRate;
    private String comment;
}
