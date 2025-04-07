package com.example.monprojet.Repository;

import com.example.monprojet.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query("SELECT s FROM Stock s WHERE s.article.idArticle = :idArticle AND s.depot.idDepo = :idDepo")
    List<Stock> findByArticleAndDepot(@Param("idArticle") Integer idArticle, @Param("idDepo") Integer idDepo);

    List<Stock> findByIdArticleAndIdDepoOrderByDatePeremption(Integer idArticle, Integer idDepot);
}
