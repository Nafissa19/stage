package com.example.monprojet.Repository;

import com.example.monprojet.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("SELECT a FROM Article a WHERE LOWER(a.designation_article) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Article> findByDesignationContaining(String keyword);

}
