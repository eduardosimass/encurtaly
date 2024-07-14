package dev.simas.Encurtaly.repository;

import dev.simas.Encurtaly.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findByUrlEncurtada(String urlEncurtada);


}
