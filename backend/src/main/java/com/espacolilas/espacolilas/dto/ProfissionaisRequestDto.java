package com.espacolilas.espacolilas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProfissionaisRequestDto(

    @NotBlank(message = "Campo obrigatório")
    String nome,

    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Email deve ser válido")
    String email,

    @NotBlank(message = "Campo obrigatório")
    String cpf,

    @NotBlank(message = "Campo obrigatório")
    String telefone,

    @NotBlank(message = "Campo obrigatório")
    String especialidade,

    @NotBlank(message = "Campo obrigatório")
    String senha

){}