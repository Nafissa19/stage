package com.example.monprojet.Factory;

import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.domain.Article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArticleFactory {
    /*public static Article articleDTOTOArticle(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setIdArticle(articleDTO.getIdArticle());
        article.setDesignation_article(articleDTO.getDesignation_article());
        return article;
    }*/
    public static ArticleDTO articleToArticleDTO(Article article) {
        if (article != null) {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setIdArticle(article.getIdArticle());
            articleDTO.setDesignation_article(article.getDesignation_article());
            return articleDTO;
        }else {
            return null;
        }
    }
    public static Collection<ArticleDTO> articlesToArticleDTOs(Collection<Article> articles) {
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = articleToArticleDTO(article);
            articleDTOS.add(articleDTO);
        }
        return articleDTOS;
    }
}
