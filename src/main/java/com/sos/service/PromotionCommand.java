package com.sos.service;

import com.sos.dto.OrderDetailDto;

public interface PromotionCommand {
    
    public OrderDetailDto applyPromotion(OrderDetailDto requestDetail);

}
