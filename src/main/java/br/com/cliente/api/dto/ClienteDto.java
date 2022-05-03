package br.com.cliente.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {

    private Long id;

    @Size(min=3, max = 40)
    @Schema(description = "Name do Cliente.",
            example = "Jimmy Page", required = true)
    private String nome;

    @Size(min=11, max = 11, message ="Cpf invalido.")
    @Schema(description = "Cpf do Cliente.",
            example = "93585482495", required = true)
    private String cpf;


    @Schema(description = "Data de Nascimento do Cliente.",
            example = "2000-10-11", required = true)
    private LocalDate dataNascimento;


    @Schema(description = "Sexo do Cliente.",
            example = "F", required = true)
    @NotNull(message = "Campo Sexo é obrigatorio.")
    private char sexo;
}
