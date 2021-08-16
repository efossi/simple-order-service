package com.sos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.OrderDto;
import com.sos.dto.OrderRequest;
import com.sos.dto.mapper.OrderMapper;
import com.sos.model.ProductDb;

@Service
public class OrderServiceStepTwoImpl implements OrderService{

    public OrderDto getOrderById(String id) {
        return new OrderDto();
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

        OrderDto orderDto = OrderMapper.fromListOfOrderDetail(details);
        return orderDto;
    }


    @Override
    public List<OrderDto> getAllOrders(Pageable pageable) {
        return new ArrayList<OrderDto>();
    }   
}