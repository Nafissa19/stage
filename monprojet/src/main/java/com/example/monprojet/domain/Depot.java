package com.example.monprojet.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Table(name = "Deepot")
@Entity
public class Depot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepo;
    private String nomDepot;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "depot",fetch = FetchType.EAGER,orphanRemoval = true)
    private Collection<Stock> stocks;






    public Integer getIdDepo() {
        return idDepo;
    }

    public void setIdDepo(Integer idDepo) {
        this.idDepo = idDepo;
    }

    public String getNomDepot() {
        return nomDepot;
    }

    public void setNomDepot(String nomDepot) {
        this.nomDepot = nomDepot;
    }

    public Collection<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Collection<Stock> stocks) {
        this.stocks = stocks;
    }
}
