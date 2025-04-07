package com.example.monprojet.domain;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table (name="article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticle;
    private String designation_article;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="article",fetch = FetchType.EAGER,orphanRemoval = true)
    private Collection<Stock> Stocks;

    public Article(Integer idArticle, String designation_article) {
        this.idArticle = idArticle;
        this.designation_article = designation_article;
    }

    /*public Article(Integer idArticle, String designation_article, Collection<Stock> stocks) {
        this.idArticle = idArticle;
        this.designation_article = designation_article;
        Stocks = stocks;
    }*/

    public Article() {

    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getDesignation_article() {
        return designation_article;
    }

    public void setDesignation_article(String designation_article) {
        this.designation_article = designation_article;
    }

    /*public Collection<Stock> getStocks() {
        return Stocks;
    }

    public void setStocks(Collection<Stock> stocks) {
        Stocks = stocks;
    }*/
}
