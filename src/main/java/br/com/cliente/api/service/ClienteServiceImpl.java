package br.com.cliente.api.service;

import br.com.cliente.api.dto.ClienteDto;
import br.com.cliente.api.exceptions.InvalidDataException;
import br.com.cliente.api.exceptions.NotFoundDataException;
import br.com.cliente.api.exceptions.RequiredDataException;
import br.com.cliente.api.model.Cliente;
import br.com.cliente.api.repository.ClienteRepository;
import br.com.cliente.api.util.Utils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;


    @Override
    public void saveCliente(ClienteDto clienteDto) {
        validarDados(clienteDto);
        Cliente cliente = (Cliente) convert(clienteDto);
        repository.save(cliente);
    }

    @Override
    public void deleteCliente(Long idCliente) {

        repository.deleteById(idCliente);
    }

    @Override
    public List<ClienteDto> listCliente(Pageable page) {

        List<Cliente> clientes = repository.findAll(page).getContent();
        return clientes.stream()
                .map(c -> ClienteDto.builder()
                        .id(c.getId())
                        .nome(c.getNome())
                        .dataNascimento(c.getDataNascimento())
                        .cpf(c.getCpf())
                        .sexo(c.getSexo())
                        .build()).collect(Collectors.toList());

    }

    @SneakyThrows
    @Override
    public ClienteDto findByDocument(String document) {
       Optional<Cliente> op = repository.findByCpf(document);
       Cliente cliente = op.orElseThrow( () -> new NotFoundDataException("Registro não encontrado"));
       return (ClienteDto) convert(cliente);

    }


    private Object convert(Object obj) {
        ModelMapper mapper = new ModelMapper();
        if (obj instanceof Cliente) {
            return mapper.map((Cliente) obj, ClienteDto.class);
        } else {
            return mapper.map((ClienteDto) obj, Cliente.class);
        }
    }


    @SneakyThrows
    private void validarDados(ClienteDto cliente) {

        if (!Utils.isCPF(cliente.getCpf())) {
            throw new InvalidDataException("Campo Cpf é invalido.");
        }
        if (cliente.getSexo() !='S' && cliente.getSexo() !='M') {
            throw new InvalidDataException("Campo Sexo é invalido.");
        }
        if (Objects.isNull(cliente.getDataNascimento()) || cliente.getDataNascimento().equals("")) {
            throw new RequiredDataException("Data de Nascimento é Obrigatorio.");
        }

    }
}
