package com.example.monprojet.domain;

import com.example.monprojet.Repository.ArticleRepository;

import com.example.monprojet.Service.ArticleService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;


/*@ExtendWith(SpringExtension.class)
@DataJpaTest*/
public class ArticleEntityTest {}
    /*@Autowired
    private EntityManager em;
    @Test
    public void createWhenDesignationIsNullShouldThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Article(1, null);  // Essai de créer un article avec une désignation null
        });
        Assertions.assertEquals("La désignation de l'article ne peut pas être vide", exception.getMessage());
    }*/



