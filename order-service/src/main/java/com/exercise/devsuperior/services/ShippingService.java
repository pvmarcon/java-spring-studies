package com.exercise.devsuperior.services;

import com.exercise.devsuperior.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order){

        double shipping;
        double basic = order.getBasic();

        if (basic < 100){
            shipping = 20.0;
        }
        else if (basic >= 100 && basic < 200.0){
            shipping = 12.0;
        }
        else{
            shipping = 0;
        }

        return shipping;
    }
}
