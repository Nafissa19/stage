package com.example.monprojet.Service;

import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.Factory.ArticleFactory;
import com.example.monprojet.Repository.ArticleRepository;
import com.example.monprojet.Repository.DepotRepository;
import com.example.monprojet.domain.Article;
import com.example.monprojet.domain.Depot;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {

    }

    @Transactional(readOnly = true)
    public ArticleDTO findArticleById(Integer idArticle) {
        Article article=articleRepository.findById(idArticle).get();
        return ArticleFactory.articleToArticleDTO(article);
    }

    @Transactional(readOnly = true)
    public Collection<ArticleDTO> findAllArticles() {
        Collection<Article> articles=articleRepository.findAll();
        return ArticleFactory.articlesToArticleDTOs(articles);
    }
    public List<Article> searchByDesignation(String keyword) {
        return articleRepository.findByDesignationContaining(keyword);
    }

    /*public ArticleDTO addArticle(ArticleDTO articleDTO) {
        Article article=ArticleFactory.articleDTOTOArticle(articleDTO);
        article=articleRepository.save(article);
        return ArticleFactory.articleToArticleDTO(article);
    }*/
    /*public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        Optional<Article> articleInBase=articleRepository.findById(articleDTO.getIdArticle());
        Preconditions.checkArgument(articleInBase.isPresent(),"Article not found");
        Article article=articleRepository.save(ArticleFactory.articleDTOTOArticle(articleDTO));
        return ArticleFactory.articleToArticleDTO(article);
    }
    public void deleteArticle(Integer idArticle) {
        articleRepository.deleteById(idArticle);
    }

    */





}
