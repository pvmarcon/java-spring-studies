package com.pvmarcon.clientcrud.repositories;

import com.pvmarcon.clientcrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
}