package com.sos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.OrderDto;
import com.sos.dto.OrderRequest;
import com.sos.dto.mapper.OrderDetailMapper;
import com.sos.dto.mapper.OrderMapper;
import com.sos.model.ProductDb;
import com.sos.model.order.Order;
import com.sos.repository.OrderRepository;

@Service
public class OrderServiceStepThreeImpl implements OrderService{

    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public OrderServiceStepThreeImpl(OrderRepository orderRepository,
            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }
    
    public OrderDto placeOrder(OrderRequest orderRequest) {
        
        Map<ProductDb, PromotionCommand> promotionMap = new HashMap<>();
        
        promotionMap.put(ProductDb.Orange, new OrangePromotion());
        promotionMap.put(ProductDb.Apple, new ApplePromotion());

        List<OrderDetailDto> details = orderRequest
            .getDetails()
            .stream()
            .map(detail -> promotionMap.get( ProductDb.valueOf(detail.getProduct().getCode()) ).applyPromotion(detail))
            .collect(Collectors.toList());

        Order order = new Order()
                .setId(UUID.randomUUID().toString())
                .setDetails(
                        details
                        .stream()
                        .map(odDto -> 
                            OrderDetailMapper.fromDto(odDto)
                        )
                        .collect(Collectors.toList())
                        );
        orderRepository.getOrders()
            .put(order.getId(),order);
        
        OrderDto result = OrderMapper.toDto(order);
        return result;
    }

    @Override
    public List<OrderDto> getAllOrders(Pageable pageable) {
        List<OrderDto> orders = new ArrayList<OrderDto>();
        orders.addAll(
                orderRepository
                .getOrders()
                .values()
                .stream()
                .map(o -> OrderMapper.toDto(o))
                .collect(Collectors.toList())
                );

        return orders;
    }

    public OrderDto getOrderById(String id){
        
        Order order = orderRepository
                .getOrders()
                .get(id);
        return OrderMapper.toDto(order);
    }

}
