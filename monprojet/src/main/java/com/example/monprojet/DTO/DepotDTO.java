package com.example.monprojet.DTO;

public class DepotDTO {
    private Integer idDepo;
    private String nomDepot;
    public DepotDTO() {}

    public DepotDTO(Integer idDepo, String nomDepot) {
        this.idDepo = idDepo;
        this.nomDepot = nomDepot;
    }

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
}
