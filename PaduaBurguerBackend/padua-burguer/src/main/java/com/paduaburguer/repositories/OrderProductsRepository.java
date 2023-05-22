package com.paduaburguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paduaburguer.model.OrderProducts;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {}
