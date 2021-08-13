package com.sos.resource;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sos.dto.OrderRequest;
import com.sos.service.OrderServiceStepOneImpl;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderResource {

    private OrderServiceStepOneImpl orderService;
    
    public OrderResource( OrderServiceStepOneImpl orderService ) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return ResponseEntity
                .ok(orderService.placeOrder( orderRequest));
    }

   
}