package dev.simas.Encurtaly.repository;

import dev.simas.Encurtaly.model.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
}
