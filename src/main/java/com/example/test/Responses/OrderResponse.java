package com.example.test.Responses;

import com.example.test.Entities.Product;
import com.example.test.Entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String date;
    private String address;
    private String description;
    private String userName;
    private List<ProductResponse> orderedProducts;
    private int count;
    private int totalPrice;
}
