package com.gordonramsay.product.service;

import com.gordonramsay.product.dto.AddProductRequest;
import com.gordonramsay.product.dto.UpdateProductRequest;
import com.gordonramsay.product.model.Product;
import com.gordonramsay.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    private static final String name = "productName";
    private static final Double msPrice = 10.0;
    private static final Double sPrice = 10.0;

    @Before
    public void createMocks()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProduct_validRequestGiven_ShouldReturnProduct() {
        Product product = new Product(name,msPrice,sPrice);
        AddProductRequest request = new AddProductRequest();
        request.setMobileSalesPrice(msPrice);
        request.setSalesPrice(sPrice);
        request.setName(name);

        Mockito.when(productRepository.save(any())).thenReturn(product);
        Product addedProduct =  productService.addProduct(request);
        assertEquals(product,addedProduct);
    }

    @Test
    void getProductByBarcode_validUuidGiven_shouldReturnProduct() {
        Product product = new Product(name,msPrice,sPrice);
        String barcode = "123e4567-e89b-42d3-a456-556642440000";
        Mockito.when(productRepository.findById(any())).thenReturn(java.util.Optional.of(product));
        Product foundProduct =  productService.getProductByBarcode(barcode);
        assertEquals(product,foundProduct);
    }

    @Test
    void getProductByBarcode_notValidUuidGiven_shouldReturnError(){ //Look here again later
        String barcode = "1234";
        Throwable throwable = assertThrows(IllegalArgumentException.class, ()-> productService.getProductByBarcode(barcode));
        assertEquals(IllegalArgumentException.class,throwable.getClass());
    }

    @Test
    void getAll_shouldReturnProductList() {
        List<Product> productList = new ArrayList<>();
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> foundProductList = productService.getAll();
        Mockito.verify(productRepository,Mockito.times(1)).findAll();
        assertEquals(productList,foundProductList);

    }

    @Test
    void updateProduct() {
        UpdateProductRequest request = new UpdateProductRequest();
        request.setBarcode("123e4567-e89b-42d3-a456-556642440000");
        request.setMobileSalesPrice(msPrice);
        request.setSalesPrice(sPrice);
        request.setName(name);

        Product product = new Product(name,msPrice,sPrice);

        Mockito.when(productRepository.findById(any())).thenReturn(java.util.Optional.of(product));

        Mockito.when(productRepository.save(any())).thenReturn(product);
        productService.updateProduct(request);

        Mockito.verify(productRepository,Mockito.times(1)).save(any());

    }
}