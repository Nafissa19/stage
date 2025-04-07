package com.example.monprojet.Service;


import com.example.monprojet.DTO.StockDTO;
import com.example.monprojet.Factory.StockFactory;
import com.example.monprojet.Repository.ArticleRepository;
import com.example.monprojet.Repository.DepotRepository;
import com.example.monprojet.Repository.StockRepository;
import com.example.monprojet.domain.Stock;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class StockService {
    @Autowired
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    @Transactional(readOnly = true)
    public StockDTO findById(Integer idstock) {
        Stock stock = stockRepository.findById(idstock).get();
        return StockFactory.stockToStockDTO(stock);
    }
    @Transactional(readOnly = true)
    public Collection<StockDTO> findAll() {
        Collection<Stock> stocks = stockRepository.findAll();
        return StockFactory.stockToStockDTOs(stocks);
    }

    public StockDTO saveStock(StockDTO stockDTO) {
        Stock stock = StockFactory.stockDTOTOStock(stockDTO);
        stock= stockRepository.save(stock);
        return StockFactory.stockToStockDTO(stock);

    }
    public List<Stock> getStockARTICLE_DEPOT(Integer idArticle, Integer idDepo) {
        return stockRepository.findByArticleAndDepot(idArticle,idDepo);
    }

   public void substractStock(Stock listStock) {
        List<Stock> stocks = stockRepository.findByIdArticleAndIdDepoOrderByDatePeremption(listStock.getIdArticle(),listStock.getIdDepo());
        if (stocks.isEmpty()) {
            throw new IllegalArgumentException("Aucun stock trouvé pour cet article et ce dépôt.");
        }
        int qte1= listStock.getQte();
        for (Stock stock : stocks) {
            if (qte1 > 0 && stock.getQte() > 0) {
                int stockQuantity = stock.getQte();
                if (stockQuantity >= qte1) {
                    stock.setQte(stockQuantity - qte1);
                    qte1 = 0;
                } else {
                    qte1 -= stockQuantity;
                    stock.setQte(0);
                }
                stockRepository.save(stock);
            }
        }
        if (qte1 > 0) {
            throw new IllegalArgumentException("Quantité insuffisante dans le stock pour satisfaire la demande.");
        }
    }

}
/*public StockDTO updateStock(StockDTO stockDTO) {
        Optional<Stock> sotokInBase= stockRepository.findById(stockDTO.getIdstock());
        Preconditions.checkArgument(sotokInBase.isPresent(),"Categore has been deleted");
        Stock stock = stockRepository.save(StockFactory.stockDTOTOStock(stockDTO));
        return StockFactory.stockToStockDTO(stock);

    }*/
    /*public void deleteStockById(Integer idStock) {
        if (!stockRepository.existsById(idStock)) {
            throw new RuntimeException("Stock with ID " + idStock + " does not exist.");
        }
        stockRepository.deleteById(idStock);
    }*/





