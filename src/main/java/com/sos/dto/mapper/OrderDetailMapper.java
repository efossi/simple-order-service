package com.sos.dto.mapper;

import java.util.UUID;

import com.sos.dto.OrderDetailDto;
import com.sos.model.order.OrderDetail;


public class OrderDetailMapper {
    
    
    public static OrderDetailDto toDto(OrderDetail detail) {

        return new OrderDetailDto()
                .setProduct( ProductMapper.toSimpleDto(detail.getProduct()))
                .setQuantity(detail.getQuantity());
    }
    
    public  static OrderDetail fromDto(OrderDetailDto detail) {

        return new OrderDetail()
                .setId(UUID.randomUUID().toString())
                .setProduct( ProductMapper.fromDto(detail.getProduct()))
                .setQuantity(detail.getQuantity());
    }
    
   
}