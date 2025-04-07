package com.example.monprojet.Controller;


import com.example.monprojet.DTO.ArticleDTO;
import com.example.monprojet.Service.ArticleService;
import com.example.monprojet.domain.Article;
import com.example.monprojet.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    private static final String ENTITY_NAME = "article";

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public Collection<ArticleDTO> getAllArticles() {
        return articleService.findAllArticles();
    }

    @GetMapping("/search")
    public List<Article> searchArticles(@RequestParam String keyword) {
        return articleService.searchByDesignation(keyword);
    }
    @GetMapping("/{idArticle}")
    public ArticleDTO getArticleById(@PathVariable Integer idArticle) {
        ArticleDTO article=articleService.findArticleById(idArticle);
        RestPreconditions.checkFound(article,ENTITY_NAME," not found");
        return articleService.findArticleById(idArticle);
    }

   /* @PostMapping
    public ResponseEntity<ArticleDTO> addArticle(@RequestBody ArticleDTO article, BindingResult bindingResults) throws URISyntaxException, MethodArgumentNotValidException {
        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        if(article.getIdArticle()!=null){
            bindingResults.addError(new FieldError(ENTITY_NAME, "code", "Post does not allow an article with a code"));
            throw new MethodArgumentNotValidException(null,bindingResults);
        }
        ArticleDTO result = articleService.addArticle(article);
        return ResponseEntity.created(new URI("/api/articles/" + result.getIdArticle())).body(result);
    }*/
    /*@PutMapping
    public ResponseEntity<ArticleDTO> updateArticle(@RequestBody ArticleDTO articleDTO, BindingResult bindingResults) throws MethodArgumentNotValidException {
        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        if(articleDTO.getIdArticle()==null){
            bindingResults.addError(new FieldError(ENTITY_NAME, "code", "Put does not allow an article without a code"));
            throw new MethodArgumentNotValidException(null,bindingResults);
        }
        ArticleDTO result =articleService.updateArticle(articleDTO);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{idArticle}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer idArticle) {
        articleService.deleteArticle(idArticle);
        return ResponseEntity.ok().build();

    }
*/








}
