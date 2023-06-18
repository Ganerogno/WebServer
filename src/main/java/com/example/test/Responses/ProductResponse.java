package com.example.test.Responses;

import com.example.test.Entities.Product;
import com.example.test.Services.StorageService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    String name;
    String description;
    int price;
    String image;
    public static List<ProductResponse> getResponseList(
            List<Product> products,StorageService storageService) throws IOException {

        List<ProductResponse> responses = new ArrayList<>();
        for (Product product: products) {
            responses.add(
                    new ProductResponse(product.getName(),
                            product.getDescription(),
                            product.getPrice(),
                            Base64.getEncoder().encodeToString(storageService.loadAsBytes(product))));
        }
        return responses;
    }
}
