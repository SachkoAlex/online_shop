package com.bsuir.trtpo.backend.dto;

import lombok.Data;

@Data
public class OrderDto {
    private CartDto cart;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
