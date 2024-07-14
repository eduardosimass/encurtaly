package dev.simas.Encurtaly.service;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import dev.simas.Encurtaly.model.Link;
import dev.simas.Encurtaly.model.QrCode;
import dev.simas.Encurtaly.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private QrCodeService qrCodeService;


    public String gerarUrlAleatoria(){
        return RandomStringUtils.randomAlphanumeric(5,10);
    }


    public Link encurtarUrl(String urlOriginal) throws IOException, WriterException {
        Link link = new Link();
        link.setUrlLonga(urlOriginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode(qrCodeService.gerarQrCode(urlOriginal));
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
