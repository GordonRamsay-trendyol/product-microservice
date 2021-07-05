package com.gordonramsay.product.service;

import com.gordonramsay.product.messaging.Publisher;
import com.gordonramsay.product.dto.AddProductRequest;
import com.gordonramsay.product.dto.UpdateProductRequest;
import com.gordonramsay.product.exception.ProductNotFound;
import com.gordonramsay.product.model.Product;
import com.gordonramsay.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private static final String UPDATE_TOPIC = "product.update";

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Product addProduct(AddProductRequest request) {
        Product product = new Product(request.getName(), request.getSalesPrice(), request.getMobileSalesPrice());
        return productRepository.save(product);
    }

    @Override
    public Product getProductByBarcode(String barcode) {
        UUID id = UUID.fromString(barcode);
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(ProductNotFound::new);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(UpdateProductRequest request) {
        UUID id = UUID.fromString(request.getBarcode());

        Product product = productRepository.findById(id).orElseThrow(ProductNotFound::new);
        // TODO: Should we check null parameters, do we want to update fields as null
        BeanUtils.copyProperties(request, product);
        Product updatedProduct = productRepository.save(product);
        kafkaTemplate.send(UPDATE_TOPIC, updatedProduct.toString());
    }
}
