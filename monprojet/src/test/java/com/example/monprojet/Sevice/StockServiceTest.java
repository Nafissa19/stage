package com.example.monprojet.Sevice;

import com.example.monprojet.DTO.StockDTO;
import com.example.monprojet.Repository.StockRepository;
import com.example.monprojet.Service.StockService;
import com.example.monprojet.domain.Stock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StockServiceTest {
    @Mock
    private StockRepository stockRepository;
    @InjectMocks
    private StockService stockService;
    @Test
    public void testSubtractStock() {
        Date currentDate = new Date();  // Date actuelle
        Stock stock = new Stock(1, 1, 1, 13, currentDate);

        List<Stock> mockStock = new ArrayList<>();

        Date date1 = new Date(121, 11, 17);  // 17 décembre 2021
        Date date2 = new Date(122, 1, 5);   // 5 février 2022
        Date date3 = new Date(124, 7, 5);   // 5 août 2024

        mockStock.add(new Stock(1, 1, 1, 7, date1));
        mockStock.add(new Stock(2, 1, 1, 3, date2));
        mockStock.add(new Stock(3, 1, 1, 5, date3));
        when(stockRepository.findByIdArticleAndIdDepoOrderByDatePeremption(stock.getIdArticle(), stock.getIdDepo()))
                .thenReturn(mockStock);

        stockService.substractStock(stock);
        assertEquals(3, mockStock.size());
        assertEquals(0, mockStock.get(0).getQte(), "Le premier stock doit être épuisé");
        assertEquals(0, mockStock.get(1).getQte(), "Le deuxième stock doit être épuisé");
        assertEquals(2, mockStock.get(2).getQte(), "Le troisième stock doit contenir 2 unités restantes");
    }

    @Test
    public void testAddStock() {
        Date currentDate = new Date();  // Date actuelle
        StockDTO stockDTO = new StockDTO(1, 1, 2, 30, currentDate);

        Date existingStockDate = new Date(124, 11, 24);  // 24 décembre 2024
        Stock existingStock = new Stock(1, 1, 2, 10, existingStockDate);

        when(stockRepository.findByArticleAndDepot(stockDTO.getIdArticle(), stockDTO.getIdDepo()))
                .thenReturn(List.of(existingStock));

        stockService.saveStock(stockDTO);

        assertEquals(10, existingStock.getQte(), "La quantité du stock doit être mise à jour à 40");
    }
}
