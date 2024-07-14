package dev.simas.Encurtaly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "QrCode")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QrCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QrCodeImage", length = 1024)
    private String QrCodeImage;


}
