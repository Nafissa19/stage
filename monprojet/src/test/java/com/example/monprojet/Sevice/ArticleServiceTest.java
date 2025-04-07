package com.example.monprojet.Sevice;

import com.example.monprojet.Controller.ArticleController;
import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.Service.ArticleService;
import com.example.monprojet.domain.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    @Test
    void testGetAllArticles() {
        List<ArticleDTO> mockArticlesDTO = new ArrayList<>();
        mockArticlesDTO.add(new ArticleDTO(1, "DOLIPRANE 1000 mg"));
        mockArticlesDTO.add(new ArticleDTO(2, "DOLVEN 400 mg"));

        Mockito.when(articleService.findAllArticles()).thenReturn(mockArticlesDTO);

        Collection<ArticleDTO> result = articleController.getAllArticles();

        Assertions.assertNotNull(result, "La liste des articles ne doit pas être nulle");
        assertEquals(2, result.size());
        assertTrue(result.containsAll(mockArticlesDTO));
    }

    @Test
    public void testSearchArticlesByDesignation() {
        Article article1 = new Article(1, "DOLIPRANE 1000 mg");
        Article article2 = new Article(2, "DOLVEN 400 mg");
        List<Article> articles = Arrays.asList(article1, article2);

        Mockito.when(articleController.searchArticles("DOL")).thenReturn(articles);

        List<Article> result = articleService.searchByDesignation("DOL");

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(a -> a.getDesignation_article().contains("DOL")));
    }


}





