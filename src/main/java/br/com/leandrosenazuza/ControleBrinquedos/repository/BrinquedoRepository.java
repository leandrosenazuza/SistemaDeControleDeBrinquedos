package br.com.leandrosenazuza.ControleBrinquedos.repository;

import br.com.leandrosenazuza.ControleBrinquedos.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer> {
}
