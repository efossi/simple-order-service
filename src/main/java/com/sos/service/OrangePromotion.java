package com.sos.service;

import org.springframework.stereotype.Service;

import com.sos.dto.OrderDetailDto;
import com.sos.dto.ProductDto;
import com.sos.dto.PromotionalProductDto;
import com.sos.model.ProductDb;

@Service
public class OrangePromotion implements PromotionCommand{

    public OrderDetailDto applyPromotion(OrderDetailDto requestDetails) {
        int totalNumnerOfElements = requestDetails.getQuantity();
        
        double totalPrice = (2 * (totalNumnerOfElements/3) * ProductDb.Orange.getPrice()) +
                ((totalNumnerOfElements % 3) * ProductDb.Orange.getPrice());
       
        ProductDto promotionalOrange = new PromotionalProductDto()
                .setCode(ProductDb.Orange.toString())
                .setPrice(totalPrice/totalNumnerOfElements);
        
        OrderDetailDto orangeOrderDetail = new OrderDetailDto()
                        .setProduct(promotionalOrange)
                        .setQuantity(totalNumnerOfElements);
        
        return orangeOrderDetail;
    }
    
}