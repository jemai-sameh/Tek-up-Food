package com.tekup.service.interfaces;

import com.tekup.dto.OrderDetailsDto;
import com.tekup.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface OrderServiceInterface extends GenericInterface<OrderDto> {
     ResponseEntity<OrderDto> saveOrder(OrderDetailsDto entity);
}
