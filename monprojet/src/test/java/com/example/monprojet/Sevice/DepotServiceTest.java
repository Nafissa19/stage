package com.example.monprojet.Sevice;

import com.example.monprojet.Controller.DepotController;
import com.example.monprojet.DTO.DepotDTO;
import com.example.monprojet.Service.DepotService;
import com.example.monprojet.domain.Depot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepotServiceTest {
    @Mock
    private DepotService depotService;

    @InjectMocks
    private DepotController depotController;

    @Test
    public void testGetAllDepot() {
        List<DepotDTO> mockDepotDTO = new ArrayList<>();
        mockDepotDTO.add(new DepotDTO(1, "depot1"));
        mockDepotDTO.add(new DepotDTO(2, "depot2"));

        Mockito.when(depotService.findAll()).thenReturn(mockDepotDTO);
        Collection<DepotDTO> result=depotController.getAllDepots();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsAll(mockDepotDTO));


    }


}
