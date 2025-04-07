package com.example.monprojet.DTO;

public class ArticleDTO {
    private Integer idArticle;
    private String designation_article;

    public ArticleDTO(Integer idArticle, String designation_article) {
        this.idArticle = idArticle;
        this.designation_article = designation_article;}

    public ArticleDTO() {}

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
}
