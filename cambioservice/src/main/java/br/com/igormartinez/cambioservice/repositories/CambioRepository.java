package br.com.igormartinez.cambioservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igormartinez.cambioservice.models.Cambio;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, Long>{
    
    Optional<Cambio> findByFromAndTo(String from, String to) ;
}
