package ai.cargopro.repository;

import ai.cargopro.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
}
