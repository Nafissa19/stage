package com.example.monprojet.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idstock;

    private Integer idArticle;


    private Integer idDepo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idArticle",referencedColumnName = "idArticle", insertable = false, updatable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idDepo",referencedColumnName = "idDepo", insertable = false, updatable = false)
    private Depot depot;

    private int qte;
    private Date datePeremption;

    public Stock() {
    }

   /* public Stock(Integer idstock, Article article, Depot depot, int qte, Date datePeremption) {
        this.idstock = idstock;
        this.article = article;
        this.depot = depot;
        this.qte = qte;
        this.datePeremption = datePeremption;
    }*/

    public Stock(Integer idstock, Integer idArticle, Integer idDepo, int qte, Date datePeremption) {
        this.idstock = idstock;
        this.idArticle = idArticle;
        this.idDepo = idDepo;
        this.qte = qte;
        this.datePeremption = datePeremption;
    }

    /*public Stock(int idstock, int i, int i1, int qte, LocalDate localDate) {
        this.idstock = idstock;
        this.i=i;
    }*/

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Integer getIdDepo() {
        return idDepo;
    }

    public void setIdDepo(Integer idDepo) {
        this.idDepo = idDepo;
    }

    public Integer getIdstock() {
        return idstock;
    }

    public void setIdstock(Integer idstock) {
        this.idstock = idstock;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public void setArticles(Collection<Article> articles) {
    }
    @Override
    public String toString() {
        return "Stock{id=" + idstock + ", article=" + article.getDesignation_article() +
                ", depot=" + depot.getNomDepot() + ", quantity=" + qte + ", expirationDate=" + datePeremption + "}";
    }




}
