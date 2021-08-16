package com.sos.resource;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sos.dto.OrderRequest;
import com.sos.service.OrderServiceStepThreeImpl;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderResource {

    private OrderServiceStepThreeImpl orderService;
    
    public OrderResource( OrderServiceStepThreeImpl orderService ) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders(Pageable pageable) {
        return ResponseEntity
                .ok(orderService.getAllOrders(pageable));
    }
    
    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById( @PathVariable(name = "id") String id){
        return ResponseEntity
                .ok(orderService.getOrderById(id));
    }
    
    
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return ResponseEntity
                .ok(orderService.placeOrder( orderRequest));
    }

   
}