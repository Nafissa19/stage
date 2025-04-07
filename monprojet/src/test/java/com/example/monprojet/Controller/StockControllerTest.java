package com.example.monprojet.Controller;


import com.example.monprojet.Service.StockService;
import com.example.monprojet.domain.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class StockControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
    }

 /*   @Test
    public void testSubtractQteSuccess() throws Exception {
        Stock stock = new Stock(1, 1, 2, 30, new Date());

        when(stockService.substractStock(stock)).thenReturn("soustraitre avec succes");

        mockMvc.perform(post("/subtract")
                    .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(stock)))
                .andExpect(status().isOk())
                .andExpect(content().string("soustraitre avec succes"));
    }*/
    }
