package com.gordonramsay.product.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AddProductRequest {
    @NotNull(message = "product name can't be null")
    @NotBlank(message = "product name can't be blank")
    private String name;

    @NotNull
    private Double salesPrice;

    private Double mobileSalesPrice;
}
