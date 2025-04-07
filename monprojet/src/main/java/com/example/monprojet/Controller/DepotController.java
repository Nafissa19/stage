package com.example.monprojet.Controller;

import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.DTO.DepotDTO;
import com.example.monprojet.Service.DepotService;
import com.example.monprojet.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api/depot")
public class DepotController {
    @Autowired
    private DepotService depotService;

    @GetMapping
    public Collection<DepotDTO> getAllDepots(){
        return depotService.findAll();
    }

    @GetMapping("/{idDepo}")
    public DepotDTO getDepotById(@PathVariable Integer idDepo){
        DepotDTO depot=depotService.getDepotById(idDepo);
        RestPreconditions.checkFound(depot,ENTITY_NAME,"not Found");
        return depotService.getDepotById(idDepo);
    }

    @PostMapping("/savee")
    public ResponseEntity<DepotDTO> addDepot(@RequestBody DepotDTO depot, BindingResult bindingResults) throws URISyntaxException, MethodArgumentNotValidException {
        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        if(depot.getIdDepo()!=null){
            bindingResults.addError(new FieldError(ENTITY_NAME, "code", "Post does not allow an article with a code"));
            throw new MethodArgumentNotValidException(null,bindingResults);
        }
        DepotDTO result = depotService.createDepot(depot);
        return ResponseEntity.created(new URI("/api/depot/" + result.getIdDepo())).body(result);
    }
   @PutMapping
    public ResponseEntity<DepotDTO> updateDepot( @RequestBody DepotDTO depotDTO,BindingResult bindingResults) throws MethodArgumentNotValidException {
        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        if(depotDTO.getIdDepo()==null){
            bindingResults.addError(new FieldError(ENTITY_NAME, "code", "Put does not allow an article without a code"));
            throw new MethodArgumentNotValidException(null,bindingResults);
        }
        DepotDTO result = depotService.createDepot(depotDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{idDepo}")
    public ResponseEntity<Void> deleteDepot(@PathVariable Integer idDepo) {
        depotService.deleteDepot(idDepo);
        return ResponseEntity.ok().build();

    }
}
