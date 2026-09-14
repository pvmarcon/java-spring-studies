package com.pvmarcon.clientcrud.services;

import com.pvmarcon.clientcrud.dto.ClientDto;
import com.pvmarcon.clientcrud.entities.Client;
import com.pvmarcon.clientcrud.repositories.ClientRepository;
import com.pvmarcon.clientcrud.services.exceptions.DatabaseException;
import com.pvmarcon.clientcrud.services.exceptions.ResourceNotFoundException;
import com.pvmarcon.clientcrud.utils.ClientUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ClientDto findById(Long id){
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(ClientDto::new);
    }

    @Transactional
    public ClientDto insert(ClientDto dto){
        Client entity = new Client();
        ClientUtils utils = new ClientUtils(dto, entity);
        utils.copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDto(entity);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto dto){
        try {
            Client entity = repository.getReferenceById(id);
            ClientUtils utils = new ClientUtils(dto, entity);
            utils.copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Referential integrity failure");
        }
    }
}
