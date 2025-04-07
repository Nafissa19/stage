package com.example.monprojet.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.Service.ArticleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    @Test
    public void testGetAllArticles() throws Exception {
        // Crée une liste d'articles à simuler
        when(articleService.findAllArticles()).thenReturn(
                Arrays.asList(
                        new ArticleDTO(1, "DOLIPRANE 1000 mg"),
                        new ArticleDTO(2, "DOLVEN 400 mg")
                )
        );

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();

        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].designation_article").value("DOLIPRANE 1000 mg"))
                .andExpect(jsonPath("$[1].designation_article").value("DOLVEN 400 mg"));
    }
}
