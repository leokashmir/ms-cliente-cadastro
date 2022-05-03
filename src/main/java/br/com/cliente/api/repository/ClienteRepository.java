package br.com.cliente.api.repository;

import br.com.cliente.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {



    Optional<Cliente> findByCpf(String document);
}
