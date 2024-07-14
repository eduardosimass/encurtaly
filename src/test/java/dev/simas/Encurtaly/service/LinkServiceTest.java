package dev.simas.Encurtaly.service;

import dev.simas.Encurtaly.model.Link;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class LinkServiceTest {

    @InjectMocks
    private LinkService service;
    @Mock
    private Link link;



    @Test
    void gerarUrlAleatoria() {
        String urlOriginal = "http://seusite.com.br/";
        Link urlEncurtada = service.encurtarUrl(urlOriginal);

        Assertions.assertNotEquals(urlOriginal,urlEncurtada);


    }

    @Test
    void encurtarUrl() {
    }

    @Test
    void obterUrlOriginal() {
    }
}