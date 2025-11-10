package com.espacolilas.espacolilas.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(

        @NotBlank(message = "Campo obrigatório")
        String cpf,

        @NotBlank(message = "Campo obrigatório")
        String senha
) {}
