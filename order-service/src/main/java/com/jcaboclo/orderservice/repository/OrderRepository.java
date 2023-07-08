package com.jcaboclo.orderservice.repository;

import com.jcaboclo.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
