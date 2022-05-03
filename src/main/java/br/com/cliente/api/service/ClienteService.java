package br.com.cliente.api.service;

import br.com.cliente.api.dto.ClienteDto;
import br.com.cliente.api.model.Cliente;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    void saveCliente(ClienteDto cliente);
    void deleteCliente(Long idCliente);
    List<ClienteDto> listCliente(Pageable page);
    ClienteDto findByDocument(String document);

}
