package com.example.monprojet.DTO;

import java.time.LocalDate;
import java.util.Date;


public class StockDTO {
    private Integer idstock;
    private Integer idArticle;

    private Integer idDepo;
    private int qte;
    private Date datePeremption;

    /*public StockDTO(int idstock, int idArticle, int idDepo, int qte, Date date) {
    }*/

    public StockDTO(Integer idstock, Integer idArticle, Integer idDepo, int qte, Date datePeremption) {
        this.idstock = idstock;
        this.idArticle = idArticle;
        this.idDepo = idDepo;
        this.qte = qte;
        this.datePeremption = datePeremption;
    }

    public StockDTO() {
    }

    public Integer getIdstock() {
        return idstock;
    }

    public void setIdstock(Integer idstock) {
        this.idstock = idstock;
    }

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







}
