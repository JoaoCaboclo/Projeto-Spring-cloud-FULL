package com.jcaboclo.orderservice.service;

import com.jcaboclo.orderservice.dto.InventoryResponse;
import com.jcaboclo.orderservice.dto.OrderLineItemsDto;
import com.jcaboclo.orderservice.dto.OrderRequest;
import com.jcaboclo.orderservice.model.Order;
import com.jcaboclo.orderservice.model.OrderLineItems;
import com.jcaboclo.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;


    public void placeHolder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        // Call Inventory Service, and place order if product is in
        // stock
        InventoryResponse[] inventoryResponsArray =  webClient.get()
                .uri("http://localhost:8082/api/inventory",
                   uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        // com lambda
        //    inventoryResponse -> inventoryResponse.isInStock()
        // com metodo referência
        //    InventoryResponse::isInStock

        Boolean AllProductsInStock = Arrays.stream(inventoryResponsArray).allMatch(
                InventoryResponse::isInStock);

        if (AllProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems  orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode  (orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }

}
