package com.paduaburguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paduaburguer.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {}
