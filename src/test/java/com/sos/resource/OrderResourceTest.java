package com.sos.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.OrderRequest;
import com.sos.dto.ProductDto;
import com.sos.service.OrderService;


class OrderResourceTest {

    @InjectMocks
    OrderResource resource;
    
    
    @Mock
    OrderService orderService;
    
    @Mock
    HttpServletRequest request;

    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenValidOrder_ThenReturnOK(){
        
        OrderRequest orderRequest = new  OrderRequest();
        List<OrderDetailDto> orderDetails = new ArrayList<>();
        orderDetails.add(getOrderDetail("Orange", 1));
        
        orderRequest.setDetails(orderDetails);
//      assertEquals(HttpStatus.OK, resource.createOrder(orderRequest).getStatusCode());
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
