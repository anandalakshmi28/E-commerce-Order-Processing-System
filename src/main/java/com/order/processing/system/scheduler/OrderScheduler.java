package com.order.processing.system.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.order.processing.system.model.Order;
import com.order.processing.system.model.OrderStatus;
import com.order.processing.system.repository.OrderRepository;

import java.util.List;

@Component
public class OrderScheduler {

    private final OrderRepository orderRepository;

    public OrderScheduler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void updatePendingOrders() {
        List<Order> orders = orderRepository.findByStatus(OrderStatus.PENDING);

        for (Order order : orders) {
            order.setStatus(OrderStatus.PROCESSING);
        }

        orderRepository.saveAll(orders);
        System.out.println("Updated PENDING orders to PROCESSING");
    }
}
