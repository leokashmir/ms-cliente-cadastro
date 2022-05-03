package br.com.cliente.api.controller.v1;

import br.com.cliente.api.dto.ClienteDto;
import br.com.cliente.api.service.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Tag(name = "Cliente", description = " Micro-Serviço - Versão 1.0")
public class ClienteController {

    private ClienteServiceImpl service;


    @PostMapping("/add")
    public ResponseEntity<?>addCliente(@Valid @RequestBody ClienteDto cliente){
        service.saveCliente(cliente);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?>editCliente(@RequestBody ClienteDto cliente){
        service.saveCliente(cliente);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?>deleteCliente(@PathVariable Long id){
        service.deleteCliente(id);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity lisCliente( @PageableDefault(sort = "nome",
            direction = Sort.Direction.ASC,  page = 0, size = 5) Pageable page){

        return new ResponseEntity(service.listCliente(page),HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?>findCliente(@RequestHeader(value = "document") String document){
        return new ResponseEntity<>(service.findByDocument(document),HttpStatus.OK);
    }

}
