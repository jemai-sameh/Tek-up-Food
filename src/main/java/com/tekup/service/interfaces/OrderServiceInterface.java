package com.tekup.service.interfaces;

import com.tekup.dto.OrderDetailsDto;
import com.tekup.dto.OrderDto;
public interface OrderServiceInterface extends GenericInterface<OrderDto> {
     OrderDto saveOlder(OrderDetailsDto entity);
}
