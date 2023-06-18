package com.example.test.Entities.CompositeKeys;

import jakarta.persistence.Column;

import java.io.Serializable;

public class ProductPickUpPointKey implements Serializable {
    @Column(name = "product_id")
    Long productId;

    @Column(name = "pick_up_point_id")
    Long pickUpPointId;
}
