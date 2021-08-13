package com.sos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.OrderRequest;
import com.sos.dto.ProductDto;

class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceStepOneImpl orderService;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenSimpleValidOrderRequest_ThenReturnCorrectOrderTotal(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Apple", 1));
        
        orderRequest.setDetails(orderDetails);
        assertEquals(60, orderService.placeOrder(orderRequest).getOrderTotal());
        assertEquals(1, orderService.placeOrder(orderRequest).getDetails().size());
    }
    
    @Test
    public void givenComplexOrderRequest_ThenReturnCorrectOrderTotal(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Orange", 10));
        orderDetails.add(getOrderDetail("Apple", 2));
        
        orderRequest.setDetails(orderDetails);
        assertEquals(370, orderService.placeOrder(orderRequest).getOrderTotal());
        assertEquals(2, orderService.placeOrder(orderRequest).getDetails().size());
    }
    
    

    private OrderDetailDto getOrderDetail(String productCode, int quantity) {
        
        OrderDetailDto d = new OrderDetailDto();
        ProductDto p = new ProductDto();
        p.setCode(productCode);
        d.setProduct(p);
        d.setQuantity(quantity);
        return d;
    }
    
    
}
