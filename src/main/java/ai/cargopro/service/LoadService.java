package ai.cargopro.service;

import ai.cargopro.dto.LoadDto;
import ai.cargopro.entity.Load;
import ai.cargopro.entity.LoadStatus;
import ai.cargopro.repository.LoadRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class LoadService {

    private final LoadRepository repo;

    public LoadService(LoadRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Load createLoad(LoadDto dto) {
        Load l = new Load();
        l.setShipperId(dto.getShipperId());
        l.setFacility(dto.getFacility());
        l.setProductType(dto.getProductType());
        l.setTruckType(dto.getTruckType());
        l.setNoOfTrucks(dto.getNoOfTrucks());
        l.setWeight(dto.getWeight());
        l.setComment(dto.getComment());
        l.setDatePosted(dto.getDatePosted());
        l.setStatus(LoadStatus.POSTED);
        return repo.save(l);
    }

    public Page<Load> find(UUID shipperId, String truckType, String status, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable); // simple; refine with specs later
    }

    public Load get(UUID id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Load not found"));
    }

    @Transactional
    public Load update(UUID id, LoadDto dto) {
        Load l = get(id);
        l.setProductType(dto.getProductType());
        l.setWeight(dto.getWeight());
        l.setComment(dto.getComment());
        return repo.save(l);
    }

    @Transactional
    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
