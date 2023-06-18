package com.example.test.Entities;

import com.example.test.Entities.CompositeKeys.ProductPickUpPointKey;
import jakarta.persistence.*;

@Entity
public class PointStorage {
    @EmbeddedId
    ProductPickUpPointKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("pickUpPointId")
    @JoinColumn(name = "pick_up_point_id")
    PickUpPoint pickUpPoint;
    int count;
}
