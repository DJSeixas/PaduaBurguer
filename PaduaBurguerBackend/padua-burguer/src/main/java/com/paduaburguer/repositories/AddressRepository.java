package com.paduaburguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paduaburguer.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {}
