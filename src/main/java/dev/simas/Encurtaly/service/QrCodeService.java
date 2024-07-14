package dev.simas.Encurtaly.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import dev.simas.Encurtaly.model.QrCode;
import dev.simas.Encurtaly.repository.QrCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class QrCodeService {

    public QrCode gerarQrCode(String urlOriginal) throws IOException, WriterException {
        int imageSize = 200;
        BitMatrix matrix = new MultiFormatWriter().encode(urlOriginal, BarcodeFormat.QR_CODE,
                imageSize, imageSize);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", bos);
        String image = Base64.getEncoder().encodeToString(bos.toByteArray());
        QrCode qrCode  = new QrCode();
        qrCode.setQrCodeImage(image);
        return qrCode;
    }

}
