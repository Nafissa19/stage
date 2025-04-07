package com.example.monprojet.Factory;


import com.example.monprojet.DTO.StockDTO;
import com.example.monprojet.domain.Stock;

import java.util.ArrayList;
import java.util.Collection;

public class StockFactory {
    public static Stock stockDTOTOStock(StockDTO stockDTO) {
       Stock stock = new Stock();
       stock.setIdstock(stockDTO.getIdstock());
       stock.setQte(stockDTO.getQte());
       stock.setDatePeremption(stockDTO.getDatePeremption());
       stock.setIdArticle(stockDTO.getIdArticle());
       stock.setIdDepo(stockDTO.getIdDepo());
/*
       Article article = new Article();
       article.setIdArticle(stockDTO.getIdArticle());
       stock.setArticle(article);*/

       /*Depot depot = new Depot();
       depot.setIdDepo(stockDTO.getIdDepo());
       stock.setDepot(depot);*/

       return stock;
    }



    public static StockDTO stockToStockDTO(Stock stock) {
        if(stock != null){
            StockDTO stockDTO =new StockDTO();
        stockDTO.setIdArticle(stock.getIdArticle());
        stockDTO.setIdDepo(stock.getIdDepo());
        stockDTO.setIdstock(stock.getIdstock());
        stockDTO.setQte(stock.getQte());
        stockDTO.setDatePeremption(stock.getDatePeremption());

        return stockDTO;}
        else {
            return null;
        }
    }
    public static StockDTO lazyStockToStockDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setIdArticle(stock.getArticle().getIdArticle());
        stockDTO.setIdDepo(stock.getDepot().getIdDepo());
        stockDTO.setIdstock(stock.getIdstock());
        stockDTO.setQte(stock.getQte());
        stockDTO.setDatePeremption(stock.getDatePeremption());
        return stockDTO;
    }

    public static Collection<StockDTO> stockToStockDTOs(Collection<Stock> stocks) {
        Collection<StockDTO> stockDTOs = new ArrayList<>();
        for (Stock stock : stocks) {
            StockDTO stockDTO = lazyStockToStockDTO(stock);
            stockDTOs.add(stockDTO);
        }
        return stockDTOs;
    }





}
