package com.example.monprojet.Service;


import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.DTO.DepotDTO;
import com.example.monprojet.Factory.ArticleFactory;
import com.example.monprojet.Factory.DepotFactory;
import com.example.monprojet.Repository.DepotRepository;
import com.example.monprojet.domain.Article;
import com.example.monprojet.domain.Depot;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepotService {
    @Autowired
    DepotRepository depotRepository;

    @Transactional(readOnly = true)
    public DepotDTO getDepotById(Integer idDepo) {
        Depot depot=depotRepository.getReferenceById(idDepo);
        return DepotFactory.depotTODepotDTO(depot);
    }
    @Transactional(readOnly = true)
    public Collection<DepotDTO> findAll() {
        List<Depot> result=depotRepository.findAll();
        return DepotFactory.depotTOdepotDTOs(result);
    }

    public DepotDTO createDepot(DepotDTO depotDTO) {
        Depot depot=DepotFactory.depotDTOTODepot(depotDTO);
        depot=depotRepository.save(depot);
        return DepotFactory.depotTODepotDTO(depot);
    }

    public DepotDTO updatedepot(DepotDTO depotDTO) {
        Optional<Depot> articleInBase=depotRepository.findById(depotDTO.getIdDepo());
        Preconditions.checkArgument(articleInBase.isPresent(),"Depot not found");
        Depot depot=depotRepository.save(DepotFactory.depotDTOTODepot(depotDTO));
        return DepotFactory.depotTODepotDTO(depot);
    }
    public void deleteDepot(Integer idDepot) {
        depotRepository.deleteById(idDepot);
    }



}
