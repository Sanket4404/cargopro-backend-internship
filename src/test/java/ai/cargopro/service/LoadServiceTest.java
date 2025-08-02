package ai.cargopro.service;

import ai.cargopro.dto.LoadDto;
import ai.cargopro.entity.Load;
import ai.cargopro.repository.LoadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LoadServiceTest {

    @Mock
    private LoadRepository loadRepository;

    @InjectMocks
    private LoadService loadService;

    @Test
    void testCreateLoad() {
        LoadDto loadDto = new LoadDto();
        Load load = loadService.createLoad(loadDto);
        assertNotNull(load);
    }
}