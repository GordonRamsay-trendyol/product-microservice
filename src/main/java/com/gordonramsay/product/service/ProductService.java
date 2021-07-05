package com.gordonramsay.product.service;

import com.gordonramsay.product.dto.AddProductRequest;
import com.gordonramsay.product.dto.UpdateProductRequest;
import com.gordonramsay.product.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(AddProductRequest request);

    Product getProductByBarcode(String barcode);

    List<Product> getAll();

    void updateProduct(UpdateProductRequest request);
}
