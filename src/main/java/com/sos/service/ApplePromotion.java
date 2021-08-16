package com.sos.service;

import org.springframework.stereotype.Service;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.ProductDto;
import com.sos.dto.PromotionalProductDto;
import com.sos.model.ProductDb;

@Service
public class ApplePromotion implements PromotionCommand{

    public OrderDetailDto applyPromotion(OrderDetailDto requestDetails) {
        int totalNumnerOfElements = requestDetails.getQuantity();

        double totalPrice = (double) ((totalNumnerOfElements/2) * ProductDb.Apple.getPrice()) + 
                (totalNumnerOfElements % 2) * ProductDb.Apple.getPrice() ;
        
        ProductDto promotionalApple = new PromotionalProductDto()
                .setCode(ProductDb.Apple.toString())
                .setPrice(totalPrice/totalNumnerOfElements);
        
        OrderDetailDto appleOrderDetail = new OrderDetailDto()
                        .setProduct(promotionalApple)
                        .setQuantity(totalNumnerOfElements);
        return appleOrderDetail;
    }
    
}