package com.pvmarcon.clientcrud.dto;

import com.pvmarcon.clientcrud.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClientDto (
        Long id,
        @Size(min = 3, max = 80)
        @NotBlank(message = "Field required")
        String name,
        @Size(min = 11, max = 11)
        @NotBlank(message = "Field required")
        String cpf,
        @NotNull(message = "Field required")
        Double income,
        @PastOrPresent(message = "Birth date can`t be in the future")
        @NotNull(message = "Field required")
        LocalDate birthDate,
        Integer children
){
    public ClientDto(Client entity) {
        this(entity.getId(), entity.getName(), entity.getCpf(), entity.getIncome(), entity.getBirthDate(), entity.getChildren());
    }
}
