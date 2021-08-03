package com.lugonzo.springmongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String postCode;
}
