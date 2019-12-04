package com.bsuir.trtpo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDto {
    Integer userId;
    Integer productId;
    Integer quantity;
}
