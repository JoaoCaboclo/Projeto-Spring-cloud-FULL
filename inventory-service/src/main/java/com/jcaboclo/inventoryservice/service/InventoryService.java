package com.jcaboclo.inventoryservice.service;

import com.jcaboclo.inventoryservice.dto.InventoryResponse;
import com.jcaboclo.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    @Autowired
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {

        log.info("accessing Inventory");

       // log.info("Wait started for accessing Inventory");
       // Thread.sleep(10000);
       // log.info("Wait ended");

        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }

    /*
        @Transactional(readOnly = true)
        public boolean isInStock(String skuCode) {
            log.info("Checking Inventory");
            return inventoryRepository.findBySkuCode(skuCode).isPresent();
        }
    */

}
