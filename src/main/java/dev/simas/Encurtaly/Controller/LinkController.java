package dev.simas.Encurtaly.Controller;

import com.google.zxing.WriterException;
import dev.simas.Encurtaly.model.Link;
import dev.simas.Encurtaly.model.LinkResponse;
import dev.simas.Encurtaly.model.QrCode;
import dev.simas.Encurtaly.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController
public class LinkController {

@Autowired
private LinkService linkService;


 @PostMapping("/encurtaly")
    public ResponseEntity<LinkResponse> gerarUrl(@RequestBody Map<String, String> request) throws IOException, WriterException {

     String urlOriginal = request.get("urlLonga");
     Link link = linkService.encurtarUrl(urlOriginal);

     String gerarUrlDeRedirecionamento  = "https://encurtaly.onrender.com/" + link.getUrlEncurtada();
     LinkResponse response = new LinkResponse(
             link.getId(),
             link.getUrlLonga(),
             gerarUrlDeRedirecionamento,
             link.getUrlQrCode(),
             link.getUrlCriadaEm()
     );

     return ResponseEntity.status(HttpStatus.CREATED).body(response);

 }
 
 @GetMapping("/r/{urlEncurtada}")
 public void redirecionarLink(@PathVariable String urlEncurtada,  HttpServletResponse response) throws IOException {

  Link link = linkService.obterUrlOriginal(urlEncurtada);

   if (Objects.nonNull(link)){
    response.sendRedirect(link.getUrlLonga());
   }else {
    response.sendError(HttpServletResponse.SC_NOT_FOUND);
   }

 }

}
