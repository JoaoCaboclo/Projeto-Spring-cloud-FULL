package com.jcaboclo.orderservice.util;

import com.jcaboclo.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader  implements CommandLineRunner {


    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
/*        if (orderRepository.count() < 1) {
            Product product = new Product();
            product.setName("iPhone 13");
            product.setDescription("iPhone 13");
            product.setPrice(BigDecimal.valueOf(1000));
            orderRepository.save(product);
        }*/
    }
}
