package dev.simas.Encurtaly.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LinkResponse {

    private Long id;
    private String urlLonga;
    private String urlEncurtada;
    private QrCode urlQrCode;
    private LocalDateTime urlCriadaEm;
}
