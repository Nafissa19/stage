package com.example.monprojet.Controller;


import com.example.monprojet.DTO.StockDTO;
import com.example.monprojet.Service.StockService;
import com.example.monprojet.domain.Stock;
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
import java.util.List;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api/Stock")
public class StockController {
    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/getAllStock")
    public Collection<StockDTO> getAllStock() {
        return stockService.findAll();
    }

    @GetMapping("/{idstock}")
    public StockDTO findById(@PathVariable int idstock) {
        StockDTO stock = stockService.findById(idstock);
        RestPreconditions.checkFound(stock,ENTITY_NAME+" not found");
        return stockService.findById(idstock);
    }

    @GetMapping("/articles/{idArticle}/depot/{idDepo}")
    public String getStock(@PathVariable Integer idArticle, @PathVariable Integer idDepo) {
        List<Stock> stocks = stockService.getStockARTICLE_DEPOT(idArticle, idDepo);

        if (stocks != null && !stocks.isEmpty()) {
            StringBuilder result = new StringBuilder("Le stock actuel de l'article " + idArticle + " dans le dépôt " + idDepo + " est : ");
            for (Stock stock : stocks) {
                result.append(stock.toString()).append("\n");
            }
            return result.toString();
        } else {
            return "Aucune information de stock trouvée pour l'article " + idArticle + " dans le dépôt " + idDepo;
        }
    }
    @PostMapping("/add")
    public ResponseEntity<StockDTO> addstock(@RequestBody StockDTO stock, BindingResult bindingResults) throws URISyntaxException, MethodArgumentNotValidException {
        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        if (stock.getIdstock() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idstock", "Post does not allow "));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        StockDTO result = stockService.saveStock(stock);
        return ResponseEntity.created(new URI("/api/Stock/" + result.getIdstock())).body(result);
    }

    @PostMapping("/subtract")
    public ResponseEntity<String> subtractQte(@RequestBody Stock stock) {
        try {
            stockService.substractStock(stock);
            return ResponseEntity.ok("soustraitre avec succes");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
