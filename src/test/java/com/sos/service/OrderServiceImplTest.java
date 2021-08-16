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
import com.sos.dto.SimpleProductDto;

class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceStepTwoImpl orderService;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void given2Apples_ThenGetOneFree(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Apple", 2));
        
        orderRequest.setDetails(orderDetails);
        assertEquals(60, orderService.placeOrder(orderRequest).getOrderTotal());
    }
    

    @Test
    public void given3Apples_ThenGetOneFree(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Apple", 3));
        
        orderRequest.setDetails(orderDetails);
        
        assertEquals(120, orderService.placeOrder(orderRequest).getOrderTotal());
    }
    
    @Test
    public void given3Oranges_ThenGetPriceFor2(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Orange", 3));
        
        orderRequest.setDetails(orderDetails);
        
        assertEquals(50, orderService.placeOrder(orderRequest).getOrderTotal());
    }
    
    @Test
    public void given10Oranges30Apple_ThenGetRightPrice(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Orange", 10));
        orderDetails.add(getOrderDetail("Apple", 30));
        
        orderRequest.setDetails(orderDetails);
        
        assertEquals(1075, orderService.placeOrder(orderRequest).getOrderTotal());
    }
    
    @Test
    public void given10Oranges_ThenGetRightPrice(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Orange", 10));
        
        orderRequest.setDetails(orderDetails);
        
        assertEquals(175, orderService.placeOrder(orderRequest).getOrderTotal());
    }
    
    @Test
    public void given30Apple_ThenGetRightPrice(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Apple", 30));
        
        orderRequest.setDetails(orderDetails);
        
        assertEquals(900, orderService.placeOrder(orderRequest).getOrderTotal());
    }
    
    private OrderDetailDto getOrderDetail(String productCode, int quantity) {
        
        OrderDetailDto d = new OrderDetailDto();
        ProductDto p = new SimpleProductDto();
        p.setCode(productCode);
        d.setProduct(p);
        d.setQuantity(quantity);
        return d;
    } 
}
