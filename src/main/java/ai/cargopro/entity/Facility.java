package ai.cargopro.entity;
import jakarta.persistence.Embeddable;
import java.time.Instant;

@Embeddable
public class Facility {
    private String loadingPoint;
    private String unloadingPoint;
    private Instant loadingDate;
    private Instant unloadingDate;
}
