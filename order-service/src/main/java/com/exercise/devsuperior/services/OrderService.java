package com.exercise.devsuperior.services;

import com.exercise.devsuperior.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        if (order == null || order.getBasic() == null || order.getDiscount() == null) {
            throw new IllegalArgumentException("Pedido inválido");
        }

            double basic = order.getBasic();
            double discount = order.getDiscount();
            double shipping = shippingService.shipment(order);

            return basic - (basic * discount / 100) + shipping;

    }
}
