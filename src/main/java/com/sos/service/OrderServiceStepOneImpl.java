package com.sos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.sos.dto.OrderDto;
import com.sos.dto.OrderRequest;
import com.sos.dto.mapper.OrderMapper;

@Service
public class OrderServiceStepOneImpl implements OrderService{

    public List<OrderDto> getAllOrders(Pageable pageable) {
        return new ArrayList<OrderDto>();
    }

    public OrderDto getOrderById(String id) {
        return new OrderDto();
    }

    public OrderDto placeOrder(OrderRequest orderRequest) {
        OrderDto orderDto = OrderMapper.fromListOfOrderDetail(orderRequest.getDetails());
                
        return orderDto;
    }


}