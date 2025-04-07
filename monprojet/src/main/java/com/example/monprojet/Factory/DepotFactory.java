package com.example.monprojet.Factory;

import com.example.monprojet.DTO.DepotDTO;
import com.example.monprojet.domain.Depot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepotFactory {
    public static Depot depotDTOTODepot(DepotDTO depotDTO) {
        Depot depot = new Depot();
        depot.setIdDepo(depotDTO.getIdDepo());
        depot.setNomDepot(depotDTO.getNomDepot());
        return depot;
    }
    public static DepotDTO depotTODepotDTO(Depot depot) {
        DepotDTO depotDTO = new DepotDTO();
        depotDTO.setIdDepo(depot.getIdDepo());
        depotDTO.setNomDepot(depot.getNomDepot());
        return depotDTO;
    }
    public static Collection<DepotDTO> depotTOdepotDTOs(Collection<Depot> depots) {
        List<DepotDTO> depotDTOs = new ArrayList<>();
        for (Depot depot : depots) {
            DepotDTO depotDTO = depotTODepotDTO(depot);
            depotDTOs.add(depotDTO);
        }return depotDTOs;
    }
}
