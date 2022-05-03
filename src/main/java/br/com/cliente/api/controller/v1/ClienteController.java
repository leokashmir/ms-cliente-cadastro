package br.com.cliente.api.controller.v1;

import br.com.cliente.api.dto.ClienteDto;
import br.com.cliente.api.exceptions.ErrorDetail;
import br.com.cliente.api.service.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Tag(name = "Cliente", description = " Micro-Serviço - Versão 1.0")
public class ClienteController {

    private ClienteServiceImpl service;


    @Operation(summary  = "Adiciona um Cliente")
    @ApiResponses({
            @ApiResponse(responseCode  = "200", description = "Cliente adicionado com sucesso.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "204", description = "Dados não encontrado.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "405", description = "Recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "409", description = "Dados obrigatórios ou inválidos", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),})
    @PostMapping("/add")
    public ResponseEntity<?>addCliente(@Valid @RequestBody ClienteDto cliente){
        service.saveCliente(cliente);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @Operation(summary  = "Edita dados de um Cliente")
    @ApiResponses({
            @ApiResponse(responseCode  = "200", description = "Dados do cliente atualizados com sucesso.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "204", description = "Dados não encontrado.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "405", description = "Recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "409", description = "Dados obrigatórios ou inválidos", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),})
    @PutMapping("/edit")
    public ResponseEntity editCliente(@RequestBody ClienteDto cliente){
        service.saveCliente(cliente);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @Operation(summary  = "Exclui um Cliente")
    @ApiResponses({
            @ApiResponse(responseCode  = "200", description = "Cliente excluido com sucesso.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "204", description = "Dado para exclusão não encontrado.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "405", description = "Recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "409", description = "Dados obrigatórios ou inválidos", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),})
    @DeleteMapping("/del/{id}")
    public ResponseEntity<?>deleteCliente(@PathVariable Long id){
        service.deleteCliente(id);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @Operation(summary  = "Obtem uma lista de Clientes Paginada")
    @ApiResponses({
            @ApiResponse(responseCode  = "200", description = "Lista de clientes obtida com sucesso."),
            @ApiResponse(responseCode  = "204", description = "Dados não encontrado.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "405", description = "Recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "409", description = "Dados obrigatórios ou inválidos", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),})
    @GetMapping("/list")
    public ResponseEntity<List<ClienteDto>> lisCliente(@PageableDefault(sort = "nome",
            direction = Sort.Direction.ASC,  page = 0, size = 5) Pageable page){

        return new ResponseEntity<List<ClienteDto>>(service.listCliente(page),HttpStatus.OK);
    }

    @Operation(summary  = "Busca um de Cliente")
    @ApiResponses({
            @ApiResponse(responseCode  = "200", description = "Dados do cliente obtido com sucesso."),
            @ApiResponse(responseCode  = "204", description = "Dados não encontrado.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode  = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "405", description = "Recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "409", description = "Dados obrigatórios ou inválidos", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),
            @ApiResponse(responseCode  = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ErrorDetail.class))),})
    @GetMapping("/find")
    public ResponseEntity<ClienteDto>findCliente(@RequestHeader(value = "document") String document){
        return new ResponseEntity<ClienteDto>(service.findByDocument(document),HttpStatus.OK);
    }

}
