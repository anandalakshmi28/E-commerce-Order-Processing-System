package com.order.processing.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.order.processing.system.model.Order;
import com.order.processing.system.model.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);
}
