package com.paduaburguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paduaburguer.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Transactional(readOnly = true)
	Client findByEmail(String email);
}
