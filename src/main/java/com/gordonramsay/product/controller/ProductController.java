package com.gordonramsay.product.controller;

import com.gordonramsay.product.dto.AddProductRequest;
import com.gordonramsay.product.dto.UpdateProductRequest;
import com.gordonramsay.product.model.Product;
import com.gordonramsay.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody @Valid AddProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<Product> getById(@PathVariable String barcode) {
        return ResponseEntity.ok(productService.getProductByBarcode(barcode));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateProductRequest request) {
        productService.updateProduct(request);
        return ResponseEntity.ok().build();
    }
}
