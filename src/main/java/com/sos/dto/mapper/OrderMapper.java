package com.sos.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.OrderDto;
import com.sos.model.order.Order;
import com.sos.model.order.OrderDetail;
import com.sos.repository.ProductRepository;

@Service
public class OrderMapper {
    
    ProductRepository productRepository;
    public static OrderDto toDto(Order order) {
        
        return new OrderDto()
                .setId(order.getId())
                .setOrderTotal(order
                        .getDetails()
                        .stream()
                        .mapToDouble(detail -> detail.getProduct().getPrice() * detail.getQuantity())
                        .sum())
                .setDetails(new ArrayList<OrderDetailDto>(order
                        .getDetails()
                        .stream()
                        .map(d -> OrderDetailMapper.toDto(d))
                        .collect(Collectors.toList())
                ));
    }

    public static OrderDto fromListOfOrderDetail(List<OrderDetailDto> details) {

        return new OrderDto()
                .setDetails( details )
                .setOrderTotal(
                    details
                        .stream()
                        .mapToDouble(detail -> detail.getProduct().getPrice() * detail.getQuantity())
                        .sum()
                );
    }
    
    public Order fromDto(OrderDto orderDto) {

        return new Order()
                .setId(UUID.randomUUID().toString())
                .setDetails( orderDto
                        .getDetails()
                        .stream()
                        .map(odDto -> {
                            OrderDetail orderDetail = new OrderDetail()
                                    .setId(UUID.randomUUID().toString())
                                    .setQuantity(odDto.getQuantity())
                                    .setProduct(productRepository
                                            .getProducts()
                                            .values()
                                            .stream()
                                            .filter( p -> p.getCode().equals(odDto.getProduct().getCode()) )
                                            .findFirst()
                                            .orElseThrow( () -> new
                                                    RuntimeException("Invalid Product")));
                            
                            return orderDetail; 
                        })
                        .collect(Collectors.toList())
                );
    }
}

