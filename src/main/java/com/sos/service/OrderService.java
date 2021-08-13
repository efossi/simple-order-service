package com.sos.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.sos.dto.OrderDto;
import com.sos.dto.OrderRequest;

public interface OrderService {

    public List<OrderDto> getAllOrders(Pageable pageable);

    public OrderDto placeOrder(OrderRequest orderRequest);

    public OrderDto getOrderById(String id);

}