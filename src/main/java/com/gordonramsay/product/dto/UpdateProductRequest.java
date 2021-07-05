package com.gordonramsay.product.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateProductRequest {
    @NotNull
    @NotBlank
    private String barcode;

    private String name;
    private Double salesPrice;
    private Double mobileSalesPrice;
}
