package com.pvmarcon.clientcrud.utils;

import com.pvmarcon.clientcrud.dto.ClientDto;
import com.pvmarcon.clientcrud.entities.Client;

public class ClientUtils {

    private final ClientDto clientDto;
    private final Client entity;

    public ClientUtils(ClientDto clientDto, Client client) {
        this.clientDto = clientDto;
        this.entity = client;
    }

    public void copyDtoToEntity(ClientDto dto, Client entity){
        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setIncome(dto.income());
        entity.setBirthDate(dto.birthDate());
        entity.setChildren(dto.children());
    }
}
