package dev.simas.Encurtaly.service;


import dev.simas.Encurtaly.model.Link;
import dev.simas.Encurtaly.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;


    //Todo: Refactor para incluir parte da url original do nosso algoritimo de geracao de url
    //gerar uma url aleatoria
    public String gerarUrlAleatoria(){
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Link encurtarUrl(String urlOriginal) {
        Link link = new Link();
        link.setUrlLonga(urlOriginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode("QR CODE INDISPONIVEL");
        return linkRepository.save(link);
    }

    public Link obterUrlOriginal(String urlEncurtada){
        try {
            return linkRepository.findByUrlEncurtada(urlEncurtada);
        }catch (Exception e){
            throw new RuntimeException("url nao existe nos nossos registros", e);
        }
    }

}
